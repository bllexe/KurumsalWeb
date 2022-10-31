package com.tigrisSoft.KurumsalWeb.service.imp;

import com.tigrisSoft.KurumsalWeb.config.AppConfiguration;
import com.tigrisSoft.KurumsalWeb.entites.FileAttachment;
import com.tigrisSoft.KurumsalWeb.entites.Staff;
import com.tigrisSoft.KurumsalWeb.repository.FileAttachmentRepo;
import com.tigrisSoft.KurumsalWeb.service.FileAttachmentService;
import org.apache.tika.Tika;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@EnableScheduling
public class FileAttachmentServiceImpl implements FileAttachmentService {
    private Tika tika;
    private FileAttachmentRepo fileAttachmentRepo;
    private AppConfiguration appConfiguration;


    public FileAttachmentServiceImpl(FileAttachmentRepo fileAttachmentRepo,AppConfiguration appConfiguration) {
        this.tika=new Tika();
        this.fileAttachmentRepo = fileAttachmentRepo;
        this.appConfiguration=appConfiguration;
    }

    @Override
    public String writeBase64EncodedStringToFile(String image) throws IOException {
        String fileName=generateRandomName();
        File target=new File(appConfiguration.getProfileStorage() + "/" + fileName);
        OutputStream outputStream=new FileOutputStream(target);
        byte[] base64Encoded= Base64.getDecoder().decode(image);
        outputStream.write(base64Encoded);
        outputStream.close();
        return fileName;
    }

    @Override
    public String generateRandomName() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Override
    public void deleteProfileImage(String oldImageName) {
       if (oldImageName==null){
           return;
       }
       deleteFile(Paths.get(appConfiguration.getProfileStoragePath(),oldImageName));
    }

    @Override
    public void deleteAttachmentFile(String oldImageName) {
       if (oldImageName==null){
           return;
       }
       deleteFile(Paths.get(appConfiguration.getAttachmentStoragePath(),oldImageName));
    }

    @Override
    public void deleteFile(Path path) {
        try {
            Files.deleteIfExists(path);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String detectType(String base64) {
        byte[] encoded=Base64.getDecoder().decode(base64);
        return detectType(encoded);
    }

    @Override
    public String detectType(byte[] arr) {
        return tika.detect(arr);
    }

    public FileAttachment saveAttachment(MultipartFile multipartFile) {
        String fileName = generateRandomName();
        File target = new File(appConfiguration.getAttachmentStoragePath() + "/" + fileName);
        String fileType = null;
        try {
            byte[] arr = multipartFile.getBytes();
            OutputStream outputStream = new FileOutputStream(target);
            outputStream.write(arr);
            outputStream.close();
            fileType = detectType(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileAttachment fileAttachment = new FileAttachment();
        fileAttachment.setName(fileName);
        fileAttachment.setDate(new Date());
        fileAttachment.setFileType(fileType);
        return fileAttachmentRepo.save(fileAttachment);
    }

    public void deleteAllStoredFilesForUser(Staff inDB) {
        deleteProfileImage(inDB.getProfileImage());
        List<FileAttachment> filesToBeRemoved = fileAttachmentRepo.findByDateBeforeAndProjectNull(inDB.getCreateDate());
        for (FileAttachment file : filesToBeRemoved) {
            deleteAttachmentFile(file.getName());
        }
    }


}

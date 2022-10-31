package com.tigrisSoft.KurumsalWeb.service;

import com.tigrisSoft.KurumsalWeb.entites.FileAttachment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@EnableScheduling
@Service
public interface FileAttachmentService {

    FileAttachment saveAttachment(MultipartFile multipartFile);

    String writeBase64EncodedStringToFile(String image) throws IOException;

    String generateRandomName();

    void deleteProfileImage(String oldImageName);

    void deleteAttachmentFile(String oldImageName);

    void deleteFile(Path path);

    String detectType(String base64);

    String detectType(byte[] arr);


}

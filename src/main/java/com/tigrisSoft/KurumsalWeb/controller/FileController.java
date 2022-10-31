package com.tigrisSoft.KurumsalWeb.controller;

import com.tigrisSoft.KurumsalWeb.entites.FileAttachment;
import com.tigrisSoft.KurumsalWeb.service.imp.FileAttachmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    @Autowired
    FileAttachmentServiceImpl fileAttachmentService;

    @PostMapping("/fileattachment")
    FileAttachment saveProjectAttachment(MultipartFile file){
        return fileAttachmentService.saveAttachment(file);
    }
}

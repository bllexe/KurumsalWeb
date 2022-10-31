package com.tigrisSoft.KurumsalWeb.dto;

import com.tigrisSoft.KurumsalWeb.entites.FileAttachment;
import lombok.Data;

@Data
public class FileAttachmentDto {

    private String name;
    private String fileType;

    public FileAttachmentDto(FileAttachment fileAttachment){
        this.setName(fileAttachment.getName());
        this.setFileType(fileAttachment.getFileType());
    }

}

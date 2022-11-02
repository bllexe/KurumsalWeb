package com.tigrisSoft.KurumsalWeb.dto;

import com.tigrisSoft.KurumsalWeb.entites.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReferencesDto {

    private String referenceName;

    private Date timestamp;

    private FileAttachmentDto fileAttachment;

    public ReferencesDto(Reference reference){
          this.setReferenceName(reference.getReferenceName());
          this.setTimestamp(reference.getCreateDate());
          if (reference.getFileAttachment() !=null){
            this.fileAttachment=new FileAttachmentDto(reference.getFileAttachment());
          }
    }

}

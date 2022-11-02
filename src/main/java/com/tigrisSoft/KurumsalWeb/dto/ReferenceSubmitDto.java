package com.tigrisSoft.KurumsalWeb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferenceSubmitDto {

    private String referenceName;

    private Date createDate;

    private long attachmentId;
}

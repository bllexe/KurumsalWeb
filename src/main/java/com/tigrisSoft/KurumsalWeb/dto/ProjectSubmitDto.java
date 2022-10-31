package com.tigrisSoft.KurumsalWeb.dto;

import lombok.Data;

@Data
public class ProjectSubmitDto {

    private String name;

    private String  attachmentId;

    private StaffDto staffDto;
}

package com.tigrisSoft.KurumsalWeb.dto;

import com.tigrisSoft.KurumsalWeb.entites.AboutUs;
import com.tigrisSoft.KurumsalWeb.entites.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutUsDto {
    private String aboutContent;
    private String ourMission;
    private String ourVision;
    private String principles;

    public AboutUsDto(AboutUs aboutUs){
        this.setAboutContent(aboutUs.getAboutContent());
        this.setOurMission(aboutUs.getOurMission());
        this.setOurVision(aboutUs.getOurVision());
        this.setPrinciples(aboutUs.getPrinciples());

    }

}

package com.tigrisSoft.KurumsalWeb.service;

import com.tigrisSoft.KurumsalWeb.dto.AboutUsDto;
import com.tigrisSoft.KurumsalWeb.entites.AboutUs;
import org.springframework.stereotype.Service;

@Service
public interface AboutUsService {

    void addAbout(AboutUs aboutUs);

    AboutUs getAbout(long id);

    void deleteAbout(long id);

    AboutUs updateAboutUs(long id,AboutUsDto aboutUsDto);
}

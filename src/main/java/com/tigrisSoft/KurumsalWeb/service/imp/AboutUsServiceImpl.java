package com.tigrisSoft.KurumsalWeb.service.imp;

import com.tigrisSoft.KurumsalWeb.dto.AboutUsDto;
import com.tigrisSoft.KurumsalWeb.entites.AboutUs;
import com.tigrisSoft.KurumsalWeb.error.NotFoundException;
import com.tigrisSoft.KurumsalWeb.repository.AboutUsRepository;
import com.tigrisSoft.KurumsalWeb.service.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AboutUsServiceImpl implements AboutUsService {

    @Autowired
    AboutUsRepository aboutUsRepository;
    @Override
    public void addAbout(AboutUs aboutUs) {
       aboutUsRepository.save(aboutUs);
    }

    @Override
    public AboutUs getAbout(long id) {
        Optional<AboutUs> inDb=aboutUsRepository.findById(id);
        if (!inDb.isPresent()){
             throw new NotFoundException();
        }
        return aboutUsRepository.findById(id).get();
    }

    @Override
    public void deleteAbout(long id) {
        AboutUs inDb=aboutUsRepository.getReferenceById(id);
        if(inDb==null){
            throw new NotFoundException();
        }
        aboutUsRepository.deleteById(id);

    }

    @Override
    public AboutUs updateAboutUs(long id, AboutUsDto aboutUsDto) {
       AboutUs inDb=aboutUsRepository.getReferenceById(id);
       if (inDb==null){
           throw new NotFoundException();
       }
       inDb.setAboutContent(aboutUsDto.getAboutContent());
       inDb.setPrinciples(aboutUsDto.getPrinciples());
       inDb.setOurVision(aboutUsDto.getOurVision());
       inDb.setOurMission(aboutUsDto.getOurMission());
       return aboutUsRepository.save(inDb);
    }
}

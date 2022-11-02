package com.tigrisSoft.KurumsalWeb.controller;

import com.tigrisSoft.KurumsalWeb.dto.AboutUsDto;
import com.tigrisSoft.KurumsalWeb.entites.AboutUs;
import com.tigrisSoft.KurumsalWeb.service.imp.AboutUsServiceImpl;
import com.tigrisSoft.KurumsalWeb.util.ApiPaths;
import com.tigrisSoft.KurumsalWeb.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.AboutUs.CTRL)
public class AboutUsController {

    @Autowired
    AboutUsServiceImpl aboutUsService;

    @PostMapping("/add")
    GenericResponse addAbout(@RequestBody AboutUs aboutUs){
        aboutUsService.addAbout(aboutUs);
        return new GenericResponse("About add seccussfully...");
    }

    @GetMapping("/get/{id}")
    ResponseEntity<AboutUs> getAbout(@PathVariable long id){
        return ResponseEntity.ok(aboutUsService.getAbout(id));
    }

    @DeleteMapping("/delete/{id}")
    GenericResponse deleteAbout(@PathVariable long id){
        aboutUsService.deleteAbout(id);
        return new GenericResponse("AboutUs removed...");
    }

    @PutMapping("/update/{id}")
    ResponseEntity<AboutUs> updateAboutUs(@PathVariable long id,@RequestBody AboutUsDto aboutUsDto){
        return ResponseEntity.ok(aboutUsService.updateAboutUs(id,aboutUsDto));
    }


}

package com.tigrisSoft.KurumsalWeb.controller;

import com.tigrisSoft.KurumsalWeb.entites.Contact;
import com.tigrisSoft.KurumsalWeb.entites.ContactUs;
import com.tigrisSoft.KurumsalWeb.service.imp.ContactUsServiceImpl;
import com.tigrisSoft.KurumsalWeb.util.ApiPaths;
import com.tigrisSoft.KurumsalWeb.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.ContactUsCtrl.CTRL)
public class ContactUsController {

    @Autowired
    ContactUsServiceImpl contactUsService;

    @PostMapping("/add")
    private GenericResponse addContactUs(@RequestBody ContactUs contactUs){
        contactUsService.addContactUs(contactUs);
        return new GenericResponse("contact add seccesfully...");

    }

    @GetMapping("/getAll")
   private ResponseEntity<List<ContactUs>> getAllContact(){
        return ResponseEntity.ok(contactUsService.getAllContact());
    }

    @GetMapping("/getOne/{id}")
   private ResponseEntity<ContactUs> getOneContact(@PathVariable long id){
        return ResponseEntity.ok(contactUsService.getOneContact(id));
    }

    @DeleteMapping("/delete/{id}")
    private GenericResponse deleteContactUs(@PathVariable long id){
        contactUsService.deleteContactUs(id);
        return new GenericResponse("ContactUs removed seccussfully...");
    }

}

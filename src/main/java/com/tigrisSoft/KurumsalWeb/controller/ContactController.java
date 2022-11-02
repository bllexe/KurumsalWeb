package com.tigrisSoft.KurumsalWeb.controller;

import com.tigrisSoft.KurumsalWeb.entites.AboutUs;
import com.tigrisSoft.KurumsalWeb.entites.Contact;
import com.tigrisSoft.KurumsalWeb.service.imp.ContactServiceImpl;
import com.tigrisSoft.KurumsalWeb.util.ApiPaths;
import com.tigrisSoft.KurumsalWeb.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.ContactCtrl.CTRL)
public class ContactController {

    @Autowired
    ContactServiceImpl contactService;

    @PostMapping("/add")
    GenericResponse addContact(@RequestBody Contact contact){
        contactService.addContact(contact);
        return new GenericResponse("add contact seccussfully");
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Contact> getContact(@PathVariable long id){
         return ResponseEntity.ok(contactService.getContact(id));

    }
    @DeleteMapping("/delete/{id}")
    GenericResponse deleteContact(@PathVariable long id){
        contactService.deleteContact(id);
        return new GenericResponse("contact removed..");
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Contact> updateContact(@PathVariable long id,@RequestBody Contact contact){
        return ResponseEntity.ok(contactService.updateContact(id,contact));
    }
}

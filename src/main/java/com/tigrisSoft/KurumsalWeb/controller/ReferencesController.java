package com.tigrisSoft.KurumsalWeb.controller;

import com.tigrisSoft.KurumsalWeb.dto.ReferenceSubmitDto;
import com.tigrisSoft.KurumsalWeb.dto.ReferencesDto;
import com.tigrisSoft.KurumsalWeb.entites.Reference;
import com.tigrisSoft.KurumsalWeb.service.imp.ReferencesServiceImpl;
import com.tigrisSoft.KurumsalWeb.util.ApiPaths;
import com.tigrisSoft.KurumsalWeb.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping(ApiPaths.ReferencesCtrl.CTRL)
public class ReferencesController {

    @Autowired
    ReferencesServiceImpl referencesService;

    @PostMapping("/add")
    GenericResponse addReference(@RequestBody ReferenceSubmitDto reference){
        referencesService.addReference(reference);
        return new GenericResponse("add new reference");
    }
    @GetMapping("/getAll")
    Page<Reference> getAllReferences(Pageable page){
        return referencesService.getAllReferences(page);
    }

    @GetMapping("getOne/{id}")
    private Reference getOneReference(@PathVariable long id){
        return referencesService.getOneReference(id);
    }

    @DeleteMapping("/delete/{id}")
    private GenericResponse deleteReference(@PathVariable long id){
        referencesService.deleteReference(id);
        return new GenericResponse("Reference Delete seccussfully...");
    }

}

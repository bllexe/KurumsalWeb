package com.tigrisSoft.KurumsalWeb.controller;

import com.tigrisSoft.KurumsalWeb.dto.StaffDto;
import com.tigrisSoft.KurumsalWeb.dto.StaffUpdateDto;
import com.tigrisSoft.KurumsalWeb.entites.Staff;
import com.tigrisSoft.KurumsalWeb.service.imp.StaffServiceImpl;
import com.tigrisSoft.KurumsalWeb.util.ApiPaths;
import com.tigrisSoft.KurumsalWeb.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
/*@Api(value = ApiPaths.StaffCtrl.CTRL)
@RequestMapping(ApiPaths.StaffCtrl.CTRL)*/
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffServiceImpl staffServiceimpl;

    @PostMapping("/add")
    public GenericResponse createStaff(@RequestBody Staff staff){
        staffServiceimpl.createStaff(staff);
        return new GenericResponse("user created...");
    }

    @GetMapping("/getAll")
    public Page<StaffDto> getAllStaff(Pageable pageable){
      return staffServiceimpl.getAllStaff(pageable).map(StaffDto::new);
    }

    @GetMapping("/getone/{username}")
    public StaffDto getUser(@PathVariable String username){
        Staff staff=staffServiceimpl.getByUserName(username);
        return new  StaffDto(staff);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Staff>> activeStaff(){
        List<Staff> activeStaff=staffServiceimpl.activeStaff();
        return ResponseEntity.ok(activeStaff);
    }

    @GetMapping("/passive")
    public ResponseEntity<List<Staff>> passiveStaff(){
        List<Staff> passiveStaff=staffServiceimpl.passiveStaff();
        return  ResponseEntity.ok(passiveStaff);
    }

    @PutMapping("/update/{username}")
    public StaffDto updateStaff(@PathVariable(value = "username") String username, @RequestBody StaffUpdateDto updatedUser){
        Staff staff=staffServiceimpl.updateStaff(username,updatedUser);
        return new StaffDto(staff);
    }

    @DeleteMapping("/delete/{username}")
    public GenericResponse deleteStaff(@PathVariable(value = "username") String username){
        staffServiceimpl.deleteStaff(username);
        return new GenericResponse("Staff delete succesfully...");
    }


}

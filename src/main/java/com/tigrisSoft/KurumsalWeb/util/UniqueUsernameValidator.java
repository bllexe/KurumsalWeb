package com.tigrisSoft.KurumsalWeb.util;

import com.tigrisSoft.KurumsalWeb.entites.Staff;
import com.tigrisSoft.KurumsalWeb.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    @Autowired
    StaffRepository staffRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        Staff staff=staffRepository.findByUsername(username);
        if(staff !=null){
            return false;
        }
        return true;
    }
}

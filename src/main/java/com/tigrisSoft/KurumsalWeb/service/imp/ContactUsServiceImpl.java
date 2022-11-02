package com.tigrisSoft.KurumsalWeb.service.imp;

import com.tigrisSoft.KurumsalWeb.entites.Contact;
import com.tigrisSoft.KurumsalWeb.entites.ContactUs;
import com.tigrisSoft.KurumsalWeb.error.NotFoundException;
import com.tigrisSoft.KurumsalWeb.repository.ContactUsRepository;
import com.tigrisSoft.KurumsalWeb.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Override
    public void addContactUs(ContactUs contactUs) {
        contactUs.setCreateDate(new Date(System.currentTimeMillis()));
        contactUsRepository.save(contactUs);
    }
    @Override
    public List<ContactUs> getAllContact() {
       return contactUsRepository.findAll();
    }

    @Override
    public ContactUs getOneContact(long id) {
       Optional<ContactUs> conDb=contactUsRepository.findById(id);
        if(!conDb.isPresent()){
            throw new NotFoundException();
        }
        return contactUsRepository.findById(id).get();

    }

    @Override
    public void deleteContactUs(long id) {
        ContactUs conDb=contactUsRepository.getReferenceById(id);
        if(conDb ==null){
            throw new NotFoundException();
        }
        contactUsRepository.deleteById(id);
    }
}

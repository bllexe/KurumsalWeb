package com.tigrisSoft.KurumsalWeb.service;

import com.tigrisSoft.KurumsalWeb.entites.Contact;
import com.tigrisSoft.KurumsalWeb.entites.ContactUs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactUsService {
    void addContactUs(ContactUs contactUs);

    List<ContactUs> getAllContact();

    ContactUs getOneContact(long id);

    void deleteContactUs(long id);
}

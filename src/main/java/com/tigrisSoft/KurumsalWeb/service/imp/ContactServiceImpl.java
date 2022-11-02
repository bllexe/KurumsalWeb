package com.tigrisSoft.KurumsalWeb.service.imp;

import com.tigrisSoft.KurumsalWeb.entites.Contact;
import com.tigrisSoft.KurumsalWeb.error.NotFoundException;
import com.tigrisSoft.KurumsalWeb.repository.ContactRepository;
import com.tigrisSoft.KurumsalWeb.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public void addContact(Contact contact) {
     contactRepository.save(contact);
    }

    @Override
    public Contact getContact(long id) {
        Optional<Contact> inDb=contactRepository.findById(id);
        if(!inDb.isPresent()){
            throw new NotFoundException();
        }
        return contactRepository.findById(id).get();
    }

    @Override
    public void deleteContact(long id) {
        Contact conDb=contactRepository.getReferenceById(id);
        if(conDb==null){
            throw new NotFoundException();
        }
        contactRepository.deleteById(id);
    }

    @Override
    public Contact updateContact(long id, Contact contactUpdated) {

        Contact conDb=contactRepository.getReferenceById(id);
        if (conDb ==null){
            throw new NotFoundException();
        }
        conDb.setAddress(contactUpdated.getAddress());
        return contactRepository.save(conDb);

    }
}

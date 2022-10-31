package com.tigrisSoft.KurumsalWeb.service.imp;

import com.tigrisSoft.KurumsalWeb.entites.Contact;
import com.tigrisSoft.KurumsalWeb.error.NotFoundException;
import com.tigrisSoft.KurumsalWeb.repository.ContactRepository;
import com.tigrisSoft.KurumsalWeb.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public void addContact(Contact contact) {
     contactRepository.save(contact);
    }

    @Override
    public Contact getContact(long id) {
        Contact inDb=contactRepository.getReferenceById(id);
        if(inDb==null){
            throw new NotFoundException();
        }
        return inDb;
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
        if (conDb !=null){
            conDb.setAddress(contactUpdated.getAddress());
            contactRepository.save(conDb);
        }
        throw new NotFoundException();
    }
}

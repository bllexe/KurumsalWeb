package com.tigrisSoft.KurumsalWeb.service;

import com.tigrisSoft.KurumsalWeb.entites.Contact;

public interface ContactService {
    void addContact(Contact contact);

    Contact getContact(long id);

    void deleteContact(long id);

    Contact updateContact(long id, Contact contact);
}

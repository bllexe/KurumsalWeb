package com.tigrisSoft.KurumsalWeb.repository;

import com.tigrisSoft.KurumsalWeb.entites.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}

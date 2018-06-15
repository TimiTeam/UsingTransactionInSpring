package com.apress.prospring4.ch9.dao.interfaces;


import com.apress.prospring4.ch9.entities.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();
    Contact findById(Long id);
    Contact saveContact(Contact contact);
    long countAll();

}

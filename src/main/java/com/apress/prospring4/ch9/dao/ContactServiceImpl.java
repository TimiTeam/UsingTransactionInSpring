package com.apress.prospring4.ch9.dao;


import com.apress.prospring4.ch9.dao.interfaces.ContactRepository;
import com.apress.prospring4.ch9.dao.interfaces.ContactService;
import com.apress.prospring4.ch9.entities.Contact;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id).get();
    }

    public Contact saveContact(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }

    @Transactional(propagation = Propagation.NEVER)
    public long countAll() {
        return contactRepository.countAllContact();
    }
}

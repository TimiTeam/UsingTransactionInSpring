package com.apress.prospring4.ch9.dao.interfaces;


import com.apress.prospring4.ch9.entities.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Long>{

    @Query("select count(c) from Contact c")
    long countAllContact();
}

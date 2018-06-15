package com.apress.prospring4.ch9;


import com.apress.prospring4.ch9.dao.interfaces.ContactService;
import com.apress.prospring4.ch9.entities.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TxAnnotationSample {
    private static final Logger LOGGER = Logger.getLogger(TxAnnotationSample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context-annotation.xml");

        ContactService service = context.getBean("contactService",ContactService.class);

        Contact contact = service.findById(21L);
        contact.setLastName("Ivanchenko");
        service.saveContact(contact);

        simpleListAll(service.findAll());

        LOGGER.info(service.countAll());
    }
    private static void simpleListAll(List<Contact>contacts){
        for(Contact c: contacts){
            LOGGER.info(c);
        }
    }
}

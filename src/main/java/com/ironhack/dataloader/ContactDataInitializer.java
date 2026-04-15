package com.ironhack.dataloader;

import com.ironhack.entity.Contact;
import com.ironhack.entity.Name;
import com.ironhack.repository.ContactRepository;
import org.springframework.stereotype.Component;

@Component
public class ContactDataInitializer {

    private final ContactRepository contactRepository;

    public ContactDataInitializer(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void initialize() {
        if (contactRepository.count() > 0) {
            return;
        }

        Contact c1 = new Contact();
        Name n1 = new Name();
        n1.setFirstName("Ali");
        n1.setLastName("Safarli");
        c1.setName(n1);
        c1.setTitle("Student");
        c1.setCompany("Ironhack");

        Contact c2 = new Contact();
        Name n2 = new Name();
        n2.setFirstName("Omar");
        n2.setLastName("Aliyev");
        c2.setName(n2);
        c2.setTitle("Student");
        c2.setCompany("Ironhack");

        Contact c3 = new Contact();
        Name n3 = new Name();
        n3.setFirstName("Aykhan");
        n3.setLastName("Agayev");
        c3.setName(n3);
        c3.setTitle("Student");
        c3.setCompany("Ironhack");

        contactRepository.save(c1);
        contactRepository.save(c2);
        contactRepository.save(c3);
    }
}
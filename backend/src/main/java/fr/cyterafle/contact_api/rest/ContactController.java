package fr.cyterafle.contact_api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.cyterafle.contact_api.entity.ContactMessages;
import fr.cyterafle.contact_api.repository.ContactMessagesMongoRepository;

@RestController
public class ContactController {

    @Autowired
    private ContactMessagesMongoRepository mongoRepository;

    @PostMapping("/send")
    public ContactMessages newContactMessage(@RequestBody ContactMessages contactMessages){
        return mongoRepository.save(contactMessages);
    }

    @GetMapping("/all")
    public List<ContactMessages> getContactMessages(){
        return mongoRepository.findAll();
    }
}

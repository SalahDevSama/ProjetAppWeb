package fr.cyterafle.contact_api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.cyterafle.contact_api.entity.ContactMessages;
import fr.cyterafle.contact_api.entity.mongo.MongoContactMessages;
import fr.cyterafle.contact_api.entity.postgre.PostgreContactMessages;
import fr.cyterafle.contact_api.repository.jpa.ContactMessagesPostgreRepository;
import fr.cyterafle.contact_api.repository.mongo.ContactMessagesMongoRepository;

@RestController
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactMessagesMongoRepository mongoRepository;

    @Autowired
    private ContactMessagesPostgreRepository postgreRepository;

    @PostMapping("/send")
    public ContactMessages newContactMessage(@RequestBody ContactMessages contactMessages){
        MongoContactMessages mongoContactMessages = convertToMongoContactMessages(contactMessages);
        PostgreContactMessages postgreContactMessages = convertToPostgreContactMessages(contactMessages);
        mongoRepository.save(mongoContactMessages);
        postgreRepository.save(postgreContactMessages);
        return contactMessages;
    }

    @GetMapping("/messages/mongo")
    public List<MongoContactMessages> getAllMessagesFromMongo(){
        return mongoRepository.findAll();
    }

    @GetMapping("/messages/postgre")
    public List<PostgreContactMessages> getAllMessagesFromPostgre(){
        return postgreRepository.findAll();
    }

    private MongoContactMessages convertToMongoContactMessages(ContactMessages contactMessages){
        MongoContactMessages mongoContactMessages = new MongoContactMessages();
        mongoContactMessages.setName(contactMessages.getName());
        mongoContactMessages.setEmail(contactMessages.getEmail());
        mongoContactMessages.setSubject(contactMessages.getSubject());
        mongoContactMessages.setMessage(contactMessages.getMessage());
        return mongoContactMessages;
    }

    private PostgreContactMessages convertToPostgreContactMessages(ContactMessages contactMessages){
        PostgreContactMessages postgreContactMessages = new PostgreContactMessages();
        postgreContactMessages.setName(contactMessages.getName());
        postgreContactMessages.setEmail(contactMessages.getEmail());
        postgreContactMessages.setSubject(contactMessages.getSubject());
        postgreContactMessages.setMessage(contactMessages.getMessage());
        return postgreContactMessages;
    }


}

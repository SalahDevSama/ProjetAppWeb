package fr.cyterafle.contact_api.repository;

import fr.cyterafle.contact_api.entity.ContactMessages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessagesMongoRepository extends MongoRepository<ContactMessages, String> {

}

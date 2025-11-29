package fr.cyterafle.contact_api.repository.mongo;

import fr.cyterafle.contact_api.entity.mongo.MongoContactMessages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessagesMongoRepository extends MongoRepository<MongoContactMessages, String> {}

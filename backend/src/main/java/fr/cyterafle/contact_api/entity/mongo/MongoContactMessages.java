package fr.cyterafle.contact_api.entity.mongo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import fr.cyterafle.contact_api.entity.ContactMessages;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "contact_messages")
@Getter
@Setter
public class MongoContactMessages extends ContactMessages {
    @Id
    public String id;
}

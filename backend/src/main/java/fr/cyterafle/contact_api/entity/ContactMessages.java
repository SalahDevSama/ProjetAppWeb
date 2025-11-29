package fr.cyterafle.contact_api.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
public class ContactMessages {

    @Id
    private String id;

    private String name;

    private String email;

    private String subject;

    private String message;
}
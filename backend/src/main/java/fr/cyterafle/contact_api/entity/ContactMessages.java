package fr.cyterafle.contact_api.entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class ContactMessages {

    private String name;

    private String email;

    private String subject;

    private String message;
}
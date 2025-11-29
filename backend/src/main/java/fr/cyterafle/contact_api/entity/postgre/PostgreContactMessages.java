package fr.cyterafle.contact_api.entity.postgre;

import jakarta.persistence.Id;

import fr.cyterafle.contact_api.entity.ContactMessages;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contact_messages")
public class PostgreContactMessages extends ContactMessages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

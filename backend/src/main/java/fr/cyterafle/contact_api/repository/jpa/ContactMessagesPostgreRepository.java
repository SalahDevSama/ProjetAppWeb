package fr.cyterafle.contact_api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.cyterafle.contact_api.entity.postgre.PostgreContactMessages;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessagesPostgreRepository extends JpaRepository<PostgreContactMessages, Long> {}

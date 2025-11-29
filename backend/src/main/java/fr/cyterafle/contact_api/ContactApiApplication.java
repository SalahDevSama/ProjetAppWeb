package fr.cyterafle.contact_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "fr.cyterafle.contact_api.repository.mongo")
@EnableJpaRepositories(basePackages = "fr.cyterafle.contact_api.repository.jpa")
public class ContactApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactApiApplication.class, args);
	}

}

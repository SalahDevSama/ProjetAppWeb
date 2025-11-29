package fr.cyterafle.contact_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"fr.cyterafle.contact_api.rest","fr.cyterafle.contact_api.entity","fr.cyterafle.contact_api.repository"})
public class ContactApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactApiApplication.class, args);
	}

}

package ru.synergy.springJPA;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.synergy.springJPA.model.Contact;
import ru.synergy.springJPA.model.User;

import java.util.Set;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		User user_1 = new User("Kolya");
		Contact contact_1 = new Contact(user_1, "first", "123455567", "email@lll.ru");
		Contact contact_2 = new Contact(user_1, "second", "4567567777", "sefefrfrt@lll.ru");
		user_1.setContacts(Set.of(contact_1, contact_2));

//		String str = gson.toJson(user_1);
		System.out.println(user_1);

		ObjectMapper mapper = new ObjectMapper();
		try {
			// Java объект в JSON строку
			String jsonString = mapper.writeValueAsString(user_1);
			System.out.println(jsonString);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

		SpringApplication.run(SpringJpaApplication.class, args);
	}

}

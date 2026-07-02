package com.jpa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepo;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepo userRepo = context.getBean(UserRepo.class);
		
//		User user2 = new User();
//		
//		user2.setName("Shivam");
//		user2.setCity("Gorakhpur");
//		user2.setStatus("I am a Software Developer");
//		
//		User user1 = new User();
//		user1.setName("ram");
//		user1.setCity("city2");
//		user1.setStatus("I am a java Developer");
		
		
//		saving single object
//		User user1 = userRepo.save(user);
//		System.out.println(user1);

		
//		saving multiple objects
//		List<User> users =  new ArrayList<>();
//		users.add(user1);
//		users.add(user2);
//		Iterable<User> resuIterable = userRepo.saveAll(users);
//		
//		resuIterable.forEach(user->{
//			System.out.println(user);
//		});
		
		
		//update a user 
		
//		Optional<User> optional = userRepo.findById(102);
//		
//		User user = optional.get();
//		
//		user.setName("esrdftyghu");
//		
//		userRepo.save(user);
//		
		
		//delete a user by id 
		
//		userRepo.deleteById(102);
//		System.out.println("deleted");
		
		
//		delete all users
		
//		Iterable<User> allUsers =  userRepo.findAll();
//		userRepo.deleteAll(allUsers);
		
//		List<User> users = userRepo.findByName("Shivam");
		
		List<User> users = userRepo.findByNameAndCity("Shivam","Gorakhpur");
		users.forEach(e->System.out.println(e));
		
	}

}

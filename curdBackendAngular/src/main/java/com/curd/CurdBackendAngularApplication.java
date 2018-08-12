package com.curd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curd.entities.User;
import com.curd.repository.UserRepository;

@SpringBootApplication
public class CurdBackendAngularApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CurdBackendAngularApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		userRepository.save(new User("one","one"));
		userRepository.save(new User("two","one"));
		userRepository.save(new User("three","one"));
		
	}
}

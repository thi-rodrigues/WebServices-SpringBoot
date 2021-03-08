package com.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.demo.entities.User;
import com.demo.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Thiago Rodrigues", "thiago@gmail.com", "10998877665", "123456"); 
		User u2 = new User(null, "João Augusto", "joao@gmail.com", "56677889901", "654321"); 

		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}

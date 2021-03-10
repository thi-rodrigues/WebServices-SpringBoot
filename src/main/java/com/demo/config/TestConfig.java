package com.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.demo.entities.Category;
import com.demo.entities.Order;
import com.demo.entities.User;
import com.demo.repository.CategoryRepository;
import com.demo.repository.OrderRepository;
import com.demo.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Thiago Rodrigues", "thiago@gmail.com", "10998877665", "123456"); 
		User u2 = new User(null, "João Augusto", "joao@gmail.com", "56677889901", "654321"); 

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), 1, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), 2, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), 2, u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}

package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> findById = userRepository.findById(id);
		return findById.get();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User one = userRepository.getOne(id); // ID: 3
		one.setName(user.getName());
		one.setEmail(user.getEmail());
		one.setPhone(user.getPhone());
		
		return userRepository.save(one);
	}
}

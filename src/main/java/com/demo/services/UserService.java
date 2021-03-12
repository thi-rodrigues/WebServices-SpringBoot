package com.demo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.repository.UserRepository;
import com.demo.services.exception.DatabaseException;
import com.demo.services.exception.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> findById = userRepository.findById(id);
		return findById.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User user) {
		try {
			User one = userRepository.getOne(id); 
			one.setName(user.getName());
			one.setEmail(user.getEmail());
			one.setPhone(user.getPhone());
		return userRepository.save(one);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}

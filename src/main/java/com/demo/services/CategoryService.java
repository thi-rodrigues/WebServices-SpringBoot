package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Category;
import com.demo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findyAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> findById = categoryRepository.findById(id);
		return findById.get();
	}
}

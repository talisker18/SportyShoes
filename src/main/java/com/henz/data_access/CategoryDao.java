package com.henz.data_access;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henz.model.Category;

@Service
public class CategoryDao {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category getCategoryById(int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	public List<Category> getAllCategories(){
		return this.repo.findAll();
	}

}

package com.henz.data_access;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henz.model.User;

@Service
public class UserDao {
	
	@Autowired
	private UserRepository repo;
	
	public User findByName(String name) {
		return this.repo.findByUsername(name);
	}
	
	public List<User> getAllUsers(){
		return this.repo.findAll();
	}
	
	public void update(User user) {
		User existing = this.repo.findById(user.getId()).orElse(null);
		existing.setUsername(user.getUsername());
		existing.setPassword(user.getPassword());
		existing.setRole(user.getRole());
		
		this.repo.save(existing);
	}

}

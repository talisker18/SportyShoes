package com.henz.data_access;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henz.model.Shoe;

@Service
public class ShoeDao {

	@Autowired
	private ShoeRepository repo;
	
	public List<Shoe> getAllShoes(){
		return this.repo.findAll();
	}
	
	public Shoe getShoeById(int id) {
		return this.repo.getById(id);
	}
	
	public void update(Shoe shoe) {
		Shoe existing = this.repo.findById(shoe.getId()).orElse(null);
		existing.setBrand(shoe.getBrand());
		existing.setModel(shoe.getModel());
		existing.setPrice(shoe.getPrice());
		existing.setCategory(shoe.getCategory());
		
		this.repo.save(existing);
	}
}

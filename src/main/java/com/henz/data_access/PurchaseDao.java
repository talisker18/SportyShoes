package com.henz.data_access;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henz.model.Purchase;

@Service
public class PurchaseDao {
	
	@Autowired
	private PurchaseRepository repo;
	
	public List<Purchase> getAllPurchases(){
		return this.repo.findAll();
	}
}

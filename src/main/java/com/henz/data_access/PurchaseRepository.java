package com.henz.data_access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henz.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

}

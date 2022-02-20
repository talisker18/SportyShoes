package com.henz.data_access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henz.model.Shoe;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Integer>{

}

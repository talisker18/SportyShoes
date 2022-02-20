package com.henz.data_access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henz.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}

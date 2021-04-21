package com.AL.productcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AL.productcategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	
	List<Category> findAll();
	
	Optional<Category> findById(Long x);
	
	void deleteById(Long id);
	
	Category save(Category category);
}

package com.AL.productcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AL.productcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	
	List<Product> findAll();
	
	Optional<Product> findById(Long x);
	
	void deleteById(Long id);
	
	Product save(Product product);



}

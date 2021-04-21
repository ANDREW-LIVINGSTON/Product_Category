package com.AL.productcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.AL.productcategories.models.CategoryProduct;
import com.AL.productcategories.models.Product;
import com.AL.productcategories.repositories.CategoryProductRepository;
import com.AL.productcategories.repositories.ProductRepository;

@Service
public class ProductService {
	// adding the book repository as a dependency
    private final ProductRepository productRepository;
    private final CategoryProductRepository categoryProductRepository;
    public ProductService(ProductRepository productRepository, CategoryProductRepository categoryProductRepository) {
        this.productRepository = productRepository;
        this.categoryProductRepository = categoryProductRepository;
    }
    
    // returns all the books
    public List<Product> allProducts() {
        return productRepository.findAll();
    }
    // creates a book
    public Product createProduct(Product p) {
        return productRepository.save(p);
    }
    // retrieves a book
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    
    public Product updateProduct(Product p) {
    	return productRepository.save(p);
    }
    
    public void deleteProduct(Long id) {
    	productRepository.deleteById(id);
    }
    
    public Product saveProduct(Product p) {
    	return productRepository.save(p);
    }
    
    public CategoryProduct saveRelationship(CategoryProduct cp) {
    	return categoryProductRepository.save(cp);
    }
}

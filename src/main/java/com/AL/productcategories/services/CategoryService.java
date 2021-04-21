package com.AL.productcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.AL.productcategories.models.Category;
import com.AL.productcategories.models.CategoryProduct;
import com.AL.productcategories.repositories.CategoryProductRepository;
import com.AL.productcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	// adding the book repository as a dependency
    private final CategoryRepository categoryRepository;
    private final CategoryProductRepository categoryProductRepository;
    public CategoryService(CategoryRepository categoryRepository, CategoryProductRepository categoryProductRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryProductRepository = categoryProductRepository;
    }
    // returns all the books
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }
    // creates a book
    public Category createCategory(Category c) {
        return categoryRepository.save(c);
    }
    // retrieves a book
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
    public Category updateCategory(Category c) {
    	return categoryRepository.save(c);
    }
    
    public void deleteCategory(Long id) {
    	categoryRepository.deleteById(id);
    }
    
    public Category saveCategory(Category c) {
    	return categoryRepository.save(c);
    }
    
    public CategoryProduct saveRelationship(CategoryProduct cp) {
    	return categoryProductRepository.save(cp);
    }
    
}

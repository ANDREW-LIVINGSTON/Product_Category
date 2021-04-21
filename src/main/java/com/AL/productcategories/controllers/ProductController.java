package com.AL.productcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AL.productcategories.models.Category;
import com.AL.productcategories.models.CategoryProduct;
import com.AL.productcategories.models.Product;
import com.AL.productcategories.services.CategoryService;
import com.AL.productcategories.services.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

	@RequestMapping("/products/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
        return "createProduct.jsp";
	}
	@RequestMapping(value="/products", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
        	return "createProduct.jsp";
        } else {
			productService.createProduct(product);
            return "createProduct.jsp";
        }
   }
	
	@RequestMapping("/categories/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
        return "createCategory.jsp";
	}
	@RequestMapping(value="/categories", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
        	return "createCategory.jsp";
        } else {
			categoryService.createCategory(category);
            return "createCategory.jsp";
        }
   }
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productService.findProduct(id));
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);
		return "showProduct.jsp";
	}
	
	@RequestMapping(value="products/addCategory", method=RequestMethod.POST)
	public String addCategory(@RequestParam(value="product_id") Long product_id,
			@RequestParam(value="category_id") Long category_id) {
		Category c = categoryService.findCategory(category_id);
		Product p = productService.findProduct(product_id);
		
		CategoryProduct cp = new CategoryProduct(c, p);
		
		categoryService.saveRelationship(cp);
		return "showProduct.jsp";
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", categoryService.findCategory(id));
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		return "showCategory.jsp";
	}
	
	@RequestMapping(value="categories/addProduct", method=RequestMethod.POST)
	public String addProduct(@RequestParam(value="category_id") Long category_id,
			@RequestParam(value="product_id") Long product_id) {
		Category c = categoryService.findCategory(category_id);
		Product p = productService.findProduct(product_id);
		
		CategoryProduct cp = new CategoryProduct(c, p);
		
		productService.saveRelationship(cp);
		return "showCategory.jsp";
	}
}

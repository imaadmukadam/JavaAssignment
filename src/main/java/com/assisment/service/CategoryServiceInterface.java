package com.assisment.service;

import java.util.List;
import java.util.Optional;

import com.assisment.entity.Category;
import com.assisment.entity.Product;

public interface CategoryServiceInterface {
	public List<Category> getAllCategories();
	public Optional<Category> getCategoryById(Long id);
	public Category createCategory(Category category);
	public Category updateCategory(Category category);
	public void deleteCategory(Long id);
	public Product addProductToCategory(Long categoryId, Product product);
	public List<Product> getProductsByCategoryId(Long categoryId, int page, int size);
	
}

package com.assisment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assisment.entity.Category;
import com.assisment.entity.Product;
import com.assisment.service.CategoryService;
import com.assisment.service.CategoryServiceInterface;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
		@Autowired
		private CategoryServiceInterface categoryService;

		@GetMapping("/Category")
		public ResponseEntity<List<Category>> getAllCategories() {
			List<Category> categories = categoryService.getAllCategories();
			return ResponseEntity.ok(categories);
		}

		@GetMapping("/Category/{id}")
		public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
			Optional<Category> category = categoryService.getCategoryById(id);
			return category.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		}

		@PostMapping("/Category")
		public ResponseEntity<Category> createCategory(@RequestBody Category category) {
			Category createdCategory = categoryService.createCategory(category);
			return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
		}

		@PutMapping("/Category/{id}")
		public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
			category.setId(id);
			Category updatedCategory = categoryService.updateCategory(category);
			return ResponseEntity.ok(updatedCategory);
		}

		@DeleteMapping("/Category/{id}")
		public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
			categoryService.deleteCategory(id);
			return ResponseEntity.noContent().build();
		}

		@PostMapping("/Category/{categoryId}/products")
		public ResponseEntity<Product> addProductToCategory(@PathVariable Long categoryId, @RequestBody Product product) {
			Product createdProduct = categoryService.addProductToCategory(categoryId, product);
			return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
		}

		@GetMapping("/Category/{categoryId}/products")
		public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Long categoryId,
				@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
			List<Product> products = categoryService.getProductsByCategoryId(categoryId, page, size);
			return ResponseEntity.ok(products);
		}


}
	

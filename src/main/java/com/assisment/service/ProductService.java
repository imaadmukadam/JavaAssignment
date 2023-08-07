package com.assisment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.assisment.dto.CategoryDTO;
import com.assisment.dto.ProductDTO;
import com.assisment.entity.Category;
import com.assisment.entity.Product;
import com.assisment.repository.ProductRepository;
@Service
public class ProductService implements ProductServiceInterfact {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public List<Product> getAllProductsPaginated(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> products = productRepository.findAll(pageable);
		return products.getContent();
	}

	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	public ProductDTO getProductDTOById(Long id) {
		Product product = productRepository.findById(id).orElse(null);
		if (product != null) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setPrice(product.getPrice());

			
			Category category = product.getCategory();
			if (category != null) {
				CategoryDTO categoryDTO = new CategoryDTO();
				categoryDTO.setId(category.getId());
				categoryDTO.setName(category.getName());
				productDTO.setCategoryDTO(categoryDTO);
			}

			return productDTO;
		}
		return null;
	}

}

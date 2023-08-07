package com.assisment.service;

import java.util.List;
import java.util.Optional;

import com.assisment.dto.ProductDTO;
import com.assisment.entity.Product;

public interface ProductServiceInterfact {
	public List<Product> getAllProducts();
	public List<Product> getAllProductsPaginated(int page, int size);
	public Optional<Product> getProductById(Long id) ;
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public void deleteProduct(Long id);
	public ProductDTO getProductDTOById(Long id);
}

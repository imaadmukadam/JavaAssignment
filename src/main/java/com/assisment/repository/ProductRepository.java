package com.assisment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.assisment.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Page<Product> findByCategoryId(Long categoryId, org.springframework.data.domain.Pageable pageable);
}

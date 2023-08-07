package com.assisment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assisment.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

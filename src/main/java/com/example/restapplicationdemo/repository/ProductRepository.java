package com.example.restapplicationdemo.repository;

import com.example.restapplicationdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

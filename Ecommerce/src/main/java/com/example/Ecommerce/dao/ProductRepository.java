package com.example.Ecommerce.dao;

import com.example.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findByCategory(String category);
}

package com.deployment.withmysql.repo;

import com.deployment.withmysql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}

package com.deployment.withmysql;

import com.deployment.withmysql.model.Product;
import com.deployment.withmysql.repo.ProductRepo;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAllProduct() {
        return this.productRepo.findAll();
    }

    public Product addProduct(Product product) {
        return this.productRepo.save(product);
    }
}

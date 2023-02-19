package com.example.Ecommerce.service;

import com.example.Ecommerce.dao.ProductRepository;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getProduct(String category){
        List<Product> productList;
        if(null != category){
            productList = new ArrayList<>();
            if(!productRepository.findByCategory(category).isEmpty()){
                productList = productRepository.findByCategory(category);
            }else{
                return null;
            }
        }
        else{
            productList = productRepository.findAll();
        }
        return productList;
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}

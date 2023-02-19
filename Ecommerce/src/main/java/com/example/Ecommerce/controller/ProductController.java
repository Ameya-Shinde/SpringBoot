package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.ProductService;
import io.micrometer.common.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public String saveUser(@RequestBody Product product){
        productService.saveProduct(product);
        return " Product Info Saved";
    }
    @GetMapping("/getProduct") // to get all user or a single user information by providing id
    public List<Product> getUser(@Nullable @RequestParam String category){
        return  productService.getProduct(category);
    }

    @DeleteMapping("/deleteProduct")   //tp delete user information
    public String deleteUser(@RequestParam int id){
        productService.deleteProduct(id);
        return "Product with Id " + id + " Deleted Successfully";
    }
}

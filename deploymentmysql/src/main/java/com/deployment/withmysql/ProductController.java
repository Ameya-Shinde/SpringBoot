package com.deployment.withmysql;

import com.deployment.withmysql.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return this.productService.addProduct(product);
    }



}

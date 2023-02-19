package com.example.Ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @Column(name = "product_id",nullable = false)
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int price;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_category")
    private String category;

    @Column(name = "product_brand")
    private String brand;
}

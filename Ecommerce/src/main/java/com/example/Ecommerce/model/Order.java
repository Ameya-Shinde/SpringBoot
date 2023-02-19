package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @Column(name = "order_id",nullable = false)
    private int orderId;

    @Column(name = "product_quantity")
    private int productQuantity;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @JoinColumn(name = "product_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Product product;

    @JoinColumn(name = "address_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Address address;

}

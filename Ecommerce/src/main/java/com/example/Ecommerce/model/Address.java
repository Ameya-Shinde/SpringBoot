package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_address")
public class Address {

    @Id
    @Column(name = "address_id",nullable = false)
    private int addressId;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "address_landmark")
    private String landmark;

    @Column(name = "address_phone_number")
    private String addressPhoneNumber;

    @Column(name = "address_zipcode")
    private String zipcode;

    @Column(name = "address_state")
    private String state;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;


}

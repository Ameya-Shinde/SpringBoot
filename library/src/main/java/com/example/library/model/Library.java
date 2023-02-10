package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    private String name;
    private String address;
    private String number;
    private String facilities;

}

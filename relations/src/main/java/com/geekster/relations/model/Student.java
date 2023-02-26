package com.geekster.relations.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    private int StudentId;

    private String StudentName;

    private String age;

    private String phoneNumber;

    private String branch;

    @Embedded
    private Address address;

}

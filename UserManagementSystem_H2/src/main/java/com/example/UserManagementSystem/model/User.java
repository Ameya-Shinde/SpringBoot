package com.example.UserManagementSystem.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @Column(name = "user_id",nullable = false)
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_DOB")
    private String DOB;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_phone_number")
    private String phoneNumber;

    @Nullable
    @Column(name = "created_date")
    private LocalDate date;

    @Nullable
    @Column(name = "created_time")
    private Time time;


}

package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.UserService;
import io.micrometer.common.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return " User Info Saved";
    }

    @GetMapping("/getUser") // to get all user or a single user information by providing id
    public List<User> getUser(@Nullable @RequestParam Integer id){
        return  userService.getUser(id);
    }
}

package com.example.UserManagementSystem.controller;

import com.example.UserManagementSystem.model.User;
import com.example.UserManagementSystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add-user")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "User added Successfully";
    }

    @GetMapping("/find-user/{id}")
    public User findUserById(@PathVariable int id){
        return userService.getUser(id);
    }

    @GetMapping("/get-all")
    public List<User> findAllUsers(){
        return userService.getAll();
    }

    @PutMapping("/update-user/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user){
        userService.updateInfo(id, user);
        return "User Info updated successfully";
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "User Info of " + id +" Deleted successfully";
    }

    @RequestMapping("/home")
    public String helloUser(){
        return "Welcome ";
    }

}

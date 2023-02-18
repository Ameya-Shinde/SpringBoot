package com.example.UserManagementSystem.controller;

import com.example.UserManagementSystem.Util.Util;
import com.example.UserManagementSystem.model.User;
import com.example.UserManagementSystem.service.UserService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.*;


@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/userInfo")    //to add and update user information
    public List<ResponseEntity<String>> saveUser(@RequestBody String requestUser){
        JSONObject json = new JSONObject(requestUser);

        List<ResponseEntity<String>> validationList = new ArrayList<>();

        if(Util.validateUser(json).isEmpty()){
            User user = service.setUser(json);
            service.saveUser(user);
            validationList.add(new ResponseEntity<>("User Added",HttpStatus.CREATED));
            return validationList;
        }else{
            validationList = Util.validateUser(json);
            return validationList;
        }

    }


    @GetMapping("/getUser") // to get all user or a single user information by providing id
    public List<User> getUser(@Nullable @RequestParam Integer id){
        return  service.getUser(id);
    }


    @DeleteMapping("/deleteUser")   //tp delete user information
    public String deleteUser(@RequestParam int id){
         service.deleteUser(id);
        return "User Info of id " + id + " Deleted Successfully";
    }


}

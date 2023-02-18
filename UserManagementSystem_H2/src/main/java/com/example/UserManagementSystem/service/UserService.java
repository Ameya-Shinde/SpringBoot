package com.example.UserManagementSystem.service;

import com.example.UserManagementSystem.dao.UserRepository;
import com.example.UserManagementSystem.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {


    @Autowired
    UserRepository repository;

    public User setUser(JSONObject json) {
        User user = new User();

        int userId = json.getInt("userId");
        user.setUserId(userId);

        String userName = json.getString("userName");
        user.setUserName(userName);

        String DOB = json.getString("DOB");
        user.setDOB(DOB);

        String email = json.getString("email");
        user.setEmail(email);

        String phoneNumber = json.getString("phoneNumber");
        user.setPhoneNumber(phoneNumber);

        return user;
    }

    public User saveUser(User user){
        int id = user.getUserId();
        if(repository.findById(id).isPresent()){
            user.setDate(repository.findById(id).get().getDate());
            user.setTime(repository.findById(id).get().getTime());
           return repository.save(user);
        }else{
            LocalDate LocalDate = java.time.LocalDate.now();
            user.setDate(LocalDate);
            user.setTime(new Time(System.currentTimeMillis()));
           return repository.save(user);
        }
    }

    public List<User> getUser(Integer id){
        List<User> userList;
        if(null != id){
            userList = new ArrayList<>();
            if(repository.findById(id).isPresent()){
                userList.add(repository.findById(id).get());
            }else{
                return null;
            }

        }
        else{
            userList = repository.findAll();
        }
        return userList;
    }

    public void deleteUser(int id) {
         repository.deleteById(id);
    }

}

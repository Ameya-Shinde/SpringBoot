package com.example.Ecommerce.service;

import com.example.Ecommerce.dao.UserRepository;
import com.example.Ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
           userRepository.save(user);
    }

    public List<User> getUser(Integer id){
        List<User> userList;
        if(null != id){
            userList = new ArrayList<>();
            if(userRepository.findById(id).isPresent()){
                userList.add(userRepository.findById(id).get());
            }else{
                return null;
            }

        }
        else{
            userList = userRepository.findAll();
        }
        return userList;
    }
}

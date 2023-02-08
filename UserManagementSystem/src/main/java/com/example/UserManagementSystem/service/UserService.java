package com.example.UserManagementSystem.service;

import com.example.UserManagementSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List<User> users=new ArrayList<>();

    static{
        users.add(new User(101,"Ameya","grim","Swargate","1234567890"));
        users.add(new User(102,"Akshit","akki","Manapa","7894561230"));
        users.add(new User(103,"Rohini","ruhi","Lohgaon","6178523690"));

    }

    public void addUser(User user){
        users.add(user);
    }

    public User getUser(int id) {
        User u = null;
        for(User user : users){
            if(user.getUserId() == id){
                u = user;
                break;
            }
        }
        return u;
    }

    public List<User> getAll(){
        return users;
    }

    public <newUser> void updateInfo(int id, User newUser){
        User user = getUser(id);

        user.setUserId(newUser.getUserId());
        user.setName(newUser.getName());
        user.setUserName(newUser.getUserName());
        user.setAddress(newUser.getAddress());
        user.setNumber(newUser.getNumber());

    }

    public void deleteUser(int id){
        User user = getUser(id);
        users.remove(user);
    }

}

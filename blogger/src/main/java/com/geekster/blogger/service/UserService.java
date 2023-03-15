package com.geekster.blogger.service;

import com.geekster.blogger.Util.CurrentUser;
import com.geekster.blogger.model.User;
import com.geekster.blogger.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;



    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public JSONObject login (String username, String password) {
        JSONObject response = new JSONObject();
        List<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()) {
            response.put("errorMessage", "username doesn't exist");
        } else {
            User userObj = user.get(0);
            if(password.equals(userObj.getPassword())) {
                response = createResponse(userObj);
                CurrentUser.setCurrentUser(userObj.getUserId());
            }else {
                response.put("errorMessage" , "password is not valid");
            }
        }
        return response;
    }

    private JSONObject createResponse(User user) {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("userId", user.getUserId());
        jsonObj.put("username", user.getUsername());
        jsonObj.put("firstName", user.getFirstName());
        jsonObj.put("email", user.getEmail());
        jsonObj.put("phoneNumber", user.getPhoneNumber());
        return jsonObj;
    }

    public JSONArray getUsers(String userId) {
        JSONArray response = new JSONArray();
        if(null != userId) {
            List<User> usersList = userRepository.getUserByUserId(Integer.valueOf(userId));
            for (User user:usersList) {
                JSONObject userObj = createResponse(user);
                response.put(userObj);
            }
        } else {
            List<User> usersList = userRepository.findAll();
            for (User user:usersList) {
                JSONObject userObj = createResponse(user);
                response.put(userObj);
            }
        }
        return response;
    }
}

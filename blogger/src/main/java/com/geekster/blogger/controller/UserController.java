package com.geekster.blogger.controller;

import com.geekster.blogger.dto.LoginDto;
import com.geekster.blogger.model.User;
import com.geekster.blogger.repository.UserRepository;
import com.geekster.blogger.service.UserService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user){

        List<ResponseEntity<String>> validateUser = validateUserRequest(user);

        if(validateUser.isEmpty()) {
            User newUser = this.userService.createUser(user);
        } else {
            return new ResponseEntity<String>(validateUser.toString(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user.toString(), HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto requestData) {
        JSONObject requestJson = new JSONObject(requestData);
            String username = requestJson.getString("username");
            String password = requestJson.getString("password");
            JSONObject responseObj = userService.login(username, password);
            if(responseObj.has("errorMessage")) {
                return new ResponseEntity<String>(responseObj.toString(), HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity<String>(responseObj.toString(), HttpStatus.OK);
            }

    }



    private List<ResponseEntity<String>> validateUserRequest(User userData){

        List<ResponseEntity<String>> errorList = new ArrayList<>();
        List<User> userList;

        String username = userData.getUsername();
        if(!userRepository.findByUsername(username).isEmpty()){
            errorList.add(new ResponseEntity<>("Username already exists!!!", HttpStatus.BAD_REQUEST));
        }

        String email = userData.getEmail();
        if(!userRepository.findByEmail(email).isEmpty()){
            errorList.add(new ResponseEntity<>("Email already exists!!!", HttpStatus.BAD_REQUEST));
        }

        String phoneNumber = userData.getPhoneNumber();
        if(!userRepository.findByPhoneNumber(phoneNumber).isEmpty()){
            errorList.add(new ResponseEntity<>("Phone Number already exists!!!", HttpStatus.BAD_REQUEST));
        }

        return errorList;

    }


}


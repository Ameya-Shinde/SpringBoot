package com.example.UserManagementSystem.Util;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static List<ResponseEntity<String>> validateUser(JSONObject json) {

        List<ResponseEntity<String>> errorList = new ArrayList<>();

        if(!json.has("userId")){
            errorList.add(new ResponseEntity<>("Please provide User Id", HttpStatus.BAD_REQUEST));
        }

        if(!json.has("userName")){
            errorList.add(new ResponseEntity<>("Please provide User Name",HttpStatus.BAD_REQUEST));
        }else if(json.has("userName")){
            String name = json.getString("userName");
            String regex = "^[A-Za-z]\\w{5,29}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(name);
            if(!m.matches()){
                errorList.add(new ResponseEntity<>("Please provide a valid User Name",HttpStatus.BAD_REQUEST));
            }
        }

        if(!json.has("DOB")){
            errorList.add(new ResponseEntity<>("Please provide Date of Birth",HttpStatus.BAD_REQUEST));
        }else if(json.has("DOB")){
            String DOB = json.getString("DOB");
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            try {
                Date d1 = sdf.parse(DOB);
            } catch (Exception e) {
                errorList.add(new ResponseEntity<>("Please provide Date of Birth in correct format (dd-MM-yyyy)",HttpStatus.BAD_REQUEST));
            }
        }

        if(!json.has("email")){
            errorList.add(new ResponseEntity<>("Please provide email",HttpStatus.BAD_REQUEST));
        }else if(json.has("email")){
            String email = json.getString("email");
            String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(email);
            if(!m.matches()){
                errorList.add(new ResponseEntity<>("Please provide correct Email Id",HttpStatus.BAD_REQUEST));
            }
        }

        if(!json.has("phoneNumber")){
            errorList.add(new ResponseEntity<>("Please provide phone number",HttpStatus.BAD_REQUEST));
        }else if(json.has("phoneNumber")){
            String phoneNumber = json.getString("phoneNumber");
            Pattern p = Pattern.compile("^\\d{12}$");
            Matcher m = p.matcher(phoneNumber);
            if(phoneNumber.length() != 12 || m.matches() != true){
                errorList.add(new ResponseEntity<>("Please provide proper phone number with 12 digits including country code",HttpStatus.BAD_REQUEST));
            }
        }
        return errorList;
    }
}

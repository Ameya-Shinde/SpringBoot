package com.example.Ecommerce.controller;

import com.example.Ecommerce.dao.UserRepository;
import com.example.Ecommerce.model.Address;
import com.example.Ecommerce.model.Order;
import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.AddressService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressService addressService;

    @PostMapping("/address")
    public String saveUser(@RequestBody String addressRequest){
        JSONObject json = new JSONObject(addressRequest);
        Address address = setAddress(json);
        addressService.saveAddress(address);
        return " Address Saved";
    }


    @GetMapping("/getAddress")
    public Address getAddress(@RequestParam Integer id){
        return  addressService.getAddress(id);
    }

    private Address setAddress(JSONObject json){
        Address address = new Address();

        address.setAddressId(json.getInt("addressId"));
        address.setAddressName(json.getString("addressName"));
        address.setLandmark(json.getString("landmark"));
        address.setAddressPhoneNumber(json.getString("addressPhoneNumber"));
        address.setZipcode(json.getString("zipcode"));
        address.setState(json.getString("state"));

        int userId = json.getInt("user");
        User user = null;
        if(userRepository.findById(userId).isPresent()){
            user = userRepository.findById(userId).get();
        }
        address.setUser(user);

        return address;
    }

}

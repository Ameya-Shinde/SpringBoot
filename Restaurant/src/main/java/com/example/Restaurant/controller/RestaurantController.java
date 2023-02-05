package com.example.Restaurant.controller;

import com.example.Restaurant.model.Restaurant;
import com.example.Restaurant.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/home")
    public String home(){
        return "WELCOME";
    }

    @GetMapping("/list")
    public List<Restaurant> getList(){
        return this.restaurantService.getList();
    }

    @PostMapping("/add-Restaurant")
    public String addRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.addRestaurant(restaurant);
        return "Restaurant added Successfully";
    }

    //http://localhost:8080/Restaurant/{name}
    @GetMapping("/Restaurant/{name}")
    public Restaurant getRestaurant(@PathVariable String name){
        return this.restaurantService.getRestaurant(name);
    }

    //http://localhost:8080/Restaurant?name={name}
    @GetMapping("/Restaurant")
    public Restaurant getRestaurantByName(@RequestParam String name){
        return this.restaurantService.getRestaurant(name);
    }


}

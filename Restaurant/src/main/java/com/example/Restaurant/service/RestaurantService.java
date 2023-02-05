package com.example.Restaurant.service;

import com.example.Restaurant.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    private static List<Restaurant> list = new ArrayList<>(); //in memory

    static{
        list.add(new Restaurant("Punjabi Chaska","Wardha Road","1234567890","North Indian",50,4));
        list.add(new Restaurant("China King","Khamla","7894561230","Chinese",20,3));
    }



    public List<Restaurant> getList(){
        return list;
    }

    public void addRestaurant(Restaurant restaurant) {
        list.add(restaurant);
    }


    public Restaurant getRestaurant(String name) {
        Restaurant r = null;
        for(Restaurant restaurant : list){
            if(restaurant.getName().equals(name)){
                r = restaurant;
                break;
            }
        }
        return r;
    }
}

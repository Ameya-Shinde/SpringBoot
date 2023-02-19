package com.example.Ecommerce.service;

import com.example.Ecommerce.dao.OrderRepository;
import com.example.Ecommerce.model.Order;
import com.example.Ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrder(Integer id) {
        if(orderRepository.findById(id).isPresent()){
            return orderRepository.findById(id).get();
        }else{
            return null;
        }
    }
}

package com.example.Ecommerce.controller;

import com.example.Ecommerce.dao.AddressRepository;
import com.example.Ecommerce.dao.ProductRepository;
import com.example.Ecommerce.dao.UserRepository;
import com.example.Ecommerce.model.Address;
import com.example.Ecommerce.model.Order;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.OrderService;
import io.micrometer.common.lang.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AddressRepository addressRepository;


    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public String createOrder(@RequestBody String orderRequest){
        JSONObject json = new JSONObject(orderRequest);
        Order order = setOrder(json);
        orderService.saveOrder(order);
        return " Order Created";
    }

    @GetMapping("/getOrder")
    public Order getOrder(@RequestParam Integer id){
        return  orderService.getOrder(id);
    }

    private Order setOrder(JSONObject json) {
        Order order = new Order();

        order.setOrderId(json.getInt("orderId"));
        order.setProductQuantity(json.getInt("productQuantity"));

        int userId = json.getInt("user");
        User user = null;
        if(userRepository.findById(userId).isPresent()){
            user = userRepository.findById(userId).get();
        }
        order.setUser(user);

        int productId = json.getInt("product");
         Product product = null;
        if(productRepository.findById(productId).isPresent()){
            product = productRepository.findById(productId).get();
        }
        order.setProduct(product);

        int addressId = json.getInt("address");
        Address address = null;
        if(addressRepository.findById(addressId).isPresent()){
            address = addressRepository.findById(addressId).get();
        }
        order.setAddress(address);

        return order;
    }


}

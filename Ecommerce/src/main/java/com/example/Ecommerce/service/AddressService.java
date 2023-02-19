package com.example.Ecommerce.service;

import com.example.Ecommerce.dao.AddressRepository;
import com.example.Ecommerce.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    public Address getAddress(Integer id) {
        if(addressRepository.findById(id).isPresent()){
            return addressRepository.findById(id).get();
        }else{
            return null;
        }
    }
}

package com.example.urlhitcounter.controller;

import com.example.urlhitcounter.model.Visit;
import com.example.urlhitcounter.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/visitors-count")
public class UrlController {

    //@Autowired
    private UrlService urlService; // dependency injection

    public UrlController(UrlService urlService) {
        this.urlService=urlService;
    }


    //http://localhost:8080/api/v1/visitors-count/count
    @GetMapping("/count")
    public Visit getCount(){
        Visit visit = urlService.getVisits("Visitor");
        return visit;
    }

   //http://localhost:8080/api/v1/visitors-count/username/{username}/count
    @GetMapping("/username/{username}/count")
    public Visit getCount(@PathVariable String username) {
        Visit visit=urlService.getVisits(username);
        return visit;
    }

}

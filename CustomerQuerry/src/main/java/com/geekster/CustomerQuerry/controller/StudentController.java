package com.geekster.CustomerQuerry.controller;

import com.geekster.CustomerQuerry.model.Student;
import com.geekster.CustomerQuerry.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }

    @GetMapping("/findByMethod")
    public Student findByFirstname(@RequestParam String Mname){     //using method name
        Student student = service.findByName(Mname);
        return student;
    }

    @GetMapping("/countByQuerry")
    public int countByQuerry(@RequestParam boolean active){     //using method name
        int count = service.countByQuery(active);
        return count;
    }

    @GetMapping("/existsByMethod")
    public boolean existsByMethod(@RequestParam int id){
        boolean exists = service.existsByMethod(id);
        return exists;
    }

    @DeleteMapping("/deleteByQuerry")
    public void deleteByQuerry(@RequestParam int id){
        service.deleteByQuerry(id);
    }

    @GetMapping("/distinct")
    public List<String> distinctNames(){
       return service.distinctNames();
    }


}

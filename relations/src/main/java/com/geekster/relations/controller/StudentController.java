package com.geekster.relations.controller;

import com.geekster.relations.model.Student;
import com.geekster.relations.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "Student Info Saved";
    }
}

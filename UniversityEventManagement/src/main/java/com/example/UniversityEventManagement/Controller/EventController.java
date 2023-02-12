package com.example.UniversityEventManagement.Controller;

import com.example.UniversityEventManagement.Service.EventService;
import com.example.UniversityEventManagement.model.Event;
import com.example.UniversityEventManagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping("/home")
    public String helloUser(){
        return "Welcome, Date Format dd-mm-yyyy";
    }
    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student){
        eventService.addStudent(student);
        return "Student added Successfully";
    }

    @PostMapping("/add-event")
    public String addEvent(@RequestBody Event event){
        eventService.addEvent(event);
        return "Event added Successfully";
    }

    @PutMapping("/update-student/department/{id}/{department}")
    public String updateDepartment(@PathVariable int id,@PathVariable String department ){
        eventService.updateDepartment(id,department);
        return "Department Info updated successfully";
    }

    @DeleteMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable int id){
        eventService.deleteStudent(id);
        return "Student Info of " + id +" Deleted successfully";
    }

    @GetMapping("/get-all/students")
    public List<Student> findAllStudents(){
        return eventService.getAll();
    }

    @GetMapping("/get-all/events")
    public List<Event> findAllEventss(){
        return eventService.getAllEvents();
    }

    @GetMapping("/find-student/id/{id}")
    public Student findStudentById(@PathVariable int id){
        return eventService.findStudentById(id);
    }



    @PutMapping("/update-event/id/{id}")
    public String updateEvent(@PathVariable int id, @RequestBody Event event){
        eventService.updateEventInfo(id, event);
        return "Event Info updated successfully";
    }

    @DeleteMapping("/delete-event/id/{id}")
    public String deleteEvent(@PathVariable int id){
        eventService.deleteEvent(id);
        return "Event Info of " + id +" Deleted successfully";
    }

    @GetMapping("/findAll-events/date/{date}")
    public List<Event> findEventsByDate(@PathVariable String date){
        return eventService.findEventByDate(date);
    }

}

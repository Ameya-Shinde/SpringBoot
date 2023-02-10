package com.example.library.controller;

import com.example.library.model.Library;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class libraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/home")
    public String home(){
        return "WELCOME";
    }

    @GetMapping("/list")
    public List<Library> getList(){
        return this.libraryService.getList();
    }

    @PostMapping("/add-library")
    public String addLibrary(@RequestBody Library library){
        libraryService.addLibrary(library);
        return "Library Details added Successfully";
    }

    //http://localhost:8080/library/{name}
    @GetMapping("/get-library/{name}")
    public Library getLibrary(@PathVariable String name){
        return this.libraryService.getLibrary(name);
    }

    //http://localhost:8080/get-library?name={name}
    @GetMapping("/get-library")
    public Library getLibraryByName(@RequestParam String name){
        return this.libraryService.getLibrary(name);
    }

}

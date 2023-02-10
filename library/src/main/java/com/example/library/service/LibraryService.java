package com.example.library.service;

import com.example.library.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    private static List<Library> list = new ArrayList<>(); //in memory

    static{
        list.add(new Library("Crossword","Wardha Road","1234567890","AC, Water, Coffee"));
        list.add(new Library("Book House","Khamla","7894561230","Membership benefits, Board Games"));
    }

    public List<Library> getList(){
        return list;
    }

    public void addLibrary(Library library) {
        list.add(library);
    }

    public Library getLibrary(String name) {
        Library l = null;
        for(Library library : list){
            if(library.getName().equals(name)){
                l = library;
                break;
            }
        }
        return l;
    }

}

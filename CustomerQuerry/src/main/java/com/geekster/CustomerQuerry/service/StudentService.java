package com.geekster.CustomerQuerry.service;

import com.geekster.CustomerQuerry.dao.StudentRepository;
import com.geekster.CustomerQuerry.model.Student;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepository repository;

    public void addStudent(Student student) {
        student.setAdmissionDate(new Date());
        repository.save(student);
    }

    public Student findByName(String name){
       Student student = repository.findByFirstName(name);
       return student;
    }



    public int countByQuery(boolean active) {
        int count = repository.getCount(active);
        return count;
    }

    public boolean existsByMethod(int id) {
        return repository.existsById(id);
    }

    public void deleteByQuerry(int id) {
        repository.deleteById(id);
    }

    public List<String> distinctNames(){
       return repository.getDistinctByName();
    }
}

package com.geekster.CustomerQuerry.dao;

import com.geekster.CustomerQuerry.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Student findByFirstName(String name) ;

    @Query(value = "select count(*) from tbl_student where active= :active", nativeQuery = true)
    public int getCount(boolean active);

    public boolean existsById(int id);

    public void deleteById(int id);


    @Query(value = "SELECT DISTINCT s.first_name FROM tbl_student s", nativeQuery = true)
    List<String> getDistinctByName();


}


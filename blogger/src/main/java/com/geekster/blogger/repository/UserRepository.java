package com.geekster.blogger.repository;

import com.geekster.blogger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUsername(String username);

    List<User> findByEmail(String email);

    List<User> findByPhoneNumber(String phoneNumber);

    @Query(value = "select * from user where user_id = :userId", nativeQuery = true)
    public List<User> getUserByUserId(int userId);



}

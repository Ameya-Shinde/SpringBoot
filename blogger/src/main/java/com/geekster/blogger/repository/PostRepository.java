package com.geekster.blogger.repository;

import com.geekster.blogger.model.Post;
import org.json.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "select * from post where user_id =:userId", nativeQuery = true)
    List<Post> findByUserId(int userId);



}

package com.geekster.blogger.repository;

import com.geekster.blogger.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query(value = "select * from comment where post_id =:postId", nativeQuery = true)
    List<Comment> findAllCommentByPostId(int postId);
}

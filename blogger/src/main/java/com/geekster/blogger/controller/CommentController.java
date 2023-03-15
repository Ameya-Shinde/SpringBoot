package com.geekster.blogger.controller;

import com.geekster.blogger.dto.CommentDto;
import com.geekster.blogger.model.Comment;
import com.geekster.blogger.model.Post;
import com.geekster.blogger.repository.CommentRepository;
import com.geekster.blogger.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/add/{postId}")
    public ResponseEntity<?> addComment(@PathVariable int postId, @Valid @RequestBody CommentDto commentDto) {
        if(postRepository.existsById(postId)){
            Comment comment = new Comment();
            Post post = postRepository.findById(postId).get();
            comment.setPost(post);
            comment.setCommentBody(commentDto.getCommentBody());
            return  ResponseEntity.ok(commentRepository.save(comment));
        }else{
            return ResponseEntity.ok("Post not found");
        }

    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getAllCommentByPostId(@PathVariable int postId){
        List<Comment> allCommentByPostId = commentRepository.findAllCommentByPostId(postId);
        return ResponseEntity.ok(allCommentByPostId);
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable int commentId,@Valid @RequestBody CommentDto comment) {
        if (commentRepository.existsById(commentId)) {
            Comment comment1 = commentRepository.findById(commentId).get();
            comment1.setCommentBody(comment.getCommentBody());
            return ResponseEntity.ok(commentRepository.save(comment1));
        } else {
            return ResponseEntity.ok("comment not found");

        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCommentById(@PathVariable int id) {
        Map<String,Boolean> map = new HashMap<>();
        if(commentRepository.existsById(id)){
            map.put("DELETE",true);
            commentRepository.deleteById(id);
            return  ResponseEntity.ok(map);
        }
        else {
            return ResponseEntity.ok("comment not found");

        }

    }


}

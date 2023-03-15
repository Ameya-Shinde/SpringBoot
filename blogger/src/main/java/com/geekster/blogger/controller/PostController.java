package com.geekster.blogger.controller;

import com.geekster.blogger.Util.CurrentUser;
import com.geekster.blogger.dto.PostDto;
import com.geekster.blogger.dto.PostUpdateDto;
import com.geekster.blogger.model.Post;
import com.geekster.blogger.model.User;
import com.geekster.blogger.repository.UserRepository;
import com.geekster.blogger.service.PostService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Currency;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostService postService;




    @PostMapping(value = "/create")
    public ResponseEntity<String> createPost(@RequestBody PostDto postRequest) {

        Post post = setPost(postRequest);
        if(post == null){
            return new ResponseEntity<String>("UserId not found", HttpStatus.CREATED);
        }else{
            int postId = postService.savePost(post);
            return new ResponseEntity<String>(String.valueOf(postId), HttpStatus.CREATED);
        }

    }

    @GetMapping(value = "/get")
    public ResponseEntity<String> getPost(@RequestParam String userId, @Nullable @RequestParam String postId) {

        JSONArray postArr = postService.getPost(Integer.valueOf(userId), postId);
        return new ResponseEntity<String>(postArr.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable String postId, @RequestBody PostUpdateDto postRequest) {

        Post post = postService.getPostByPostId(Integer.valueOf(postId));
        int userId = post.getUser().getUserId();
        if(userId == 0){
            return  new ResponseEntity<>("Post not found", HttpStatus.BAD_REQUEST);
        }

        if(CurrentUser.currentUser == userId){
            Post editPost = setUpdatedPost(postRequest, userId);
            postService.updatePost(postId, editPost);
            return  new ResponseEntity<>("Post updated", HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("You do not have edit access or need to login ", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(value = "/delete")
    public String deleteUser(@RequestParam int id){
        postService.deleteProduct(id);
        return "Post with Id " + id + " Deleted Successfully";
    }



    private Post setPost(PostDto postRequest) {
        JSONObject jsonObject = new JSONObject(postRequest);
        User user = null;
        int userId = jsonObject.getInt("userId");
        if(userRepository.findById(userId).isPresent()) {
            user = userRepository.findById(userId).get();
        } else {
            return null;
        }
        Post post = new Post();
        post.setUser(user);
        post.setPostData(jsonObject.getString("postData"));
        Timestamp createdTime = new Timestamp(System.currentTimeMillis());
        post.setCreatedDate(createdTime);
        return post;

    }

    private Post setUpdatedPost(PostUpdateDto postRequest, int userId) {
        JSONObject jsonObject = new JSONObject(postRequest);
        User user = null;
        if(userRepository.findById(userId).isPresent()) {
            user = userRepository.findById(userId).get();
        } else {
            return null;
        }
        Post post = new Post();
        post.setUser(user);
        post.setPostData(jsonObject.getString("postData"));
        Timestamp createdTime = new Timestamp(System.currentTimeMillis());
        post.setCreatedDate(createdTime);
        return post;

    }

}

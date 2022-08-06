package com.justin.Sofkigram.controller;

import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private IPostService service;

    @GetMapping
    public List<Post> getAllPost(){
        return service.findAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return service.createPost(post);
    }

    @PostMapping
    public Post createComment(@RequestBody Comment comment){
        return service.createComment(comment);
    }

    @DeleteMapping
    public void deletePost(@RequestBody Post post){
        service.deletePost(post);
    }

    @DeleteMapping
    public void deleteComment(@RequestBody Comment comment){
        service.deleteComment(comment);
    }
}

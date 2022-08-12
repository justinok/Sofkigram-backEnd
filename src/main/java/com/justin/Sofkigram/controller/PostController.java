package com.justin.Sofkigram.controller;


import com.justin.Sofkigram.dto.PostDTO;
import com.justin.Sofkigram.service.PostService;
import com.justin.Sofkigram.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public ResponseEntity<?> createNewPost(@Valid PostDTO newPost, BindingResult result) {
        if (result.hasErrors()) {
            AtomicReference<String> message = new AtomicReference<>("");
            result.getAllErrors().forEach(objectError -> message.set(message + objectError.getDefaultMessage()));

            return new ResponseEntity<>(new ErrorMessage(message.toString()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(postService.addNewPost(newPost), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> modifyPost(@Valid PostDTO editedPost, BindingResult result) {
        if (result.hasErrors()) {
            AtomicReference<String> message = new AtomicReference<>("");
            result.getAllErrors().forEach(objectError -> message.set(message + objectError.getDefaultMessage()));

            return new ResponseEntity<>(new ErrorMessage(message.toString()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(postService.editPost(editedPost), HttpStatus.CREATED);
    }


    @DeleteMapping("/delete")
    public void deletePost(@RequestParam(name = "id") Long id) {
        postService.deletePost(id);
    }
}

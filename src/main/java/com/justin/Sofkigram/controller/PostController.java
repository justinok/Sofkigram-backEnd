package com.justin.Sofkigram.controller;


import com.justin.Sofkigram.dto.PostLikesDTO;
import com.justin.Sofkigram.service.PostServiceImplementation;
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
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostServiceImplementation postServiceImplementation;

    @GetMapping
    public List<PostLikesDTO> getAllPosts(){
        return postServiceImplementation.getAllPosts();
    }

    @PostMapping("/create/post")
    public ResponseEntity<?> createNewPost(@Valid PostLikesDTO newPost, BindingResult result) {
        if (result.hasErrors()) {
            AtomicReference<String> message = new AtomicReference<>("");
            result.getAllErrors().forEach(objectError -> message.set(message + objectError.getDefaultMessage()));

            return new ResponseEntity<>(new ErrorMessage(message.toString()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(postServiceImplementation.addNewPost(newPost), HttpStatus.CREATED);
    }

    @PutMapping("/edit/post")
    public ResponseEntity<?> modifyPost(@Valid PostLikesDTO editedPost, BindingResult result) {
        if (result.hasErrors()) {
            AtomicReference<String> message = new AtomicReference<>("");
            result.getAllErrors().forEach(objectError -> message.set(message + objectError.getDefaultMessage()));

            return new ResponseEntity<>(new ErrorMessage(message.toString()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(postServiceImplementation.editPost(editedPost), HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/post")
    public void deletePost(@RequestParam(name = "id") Long id) {
        postServiceImplementation.deletePost(id);
    }
}

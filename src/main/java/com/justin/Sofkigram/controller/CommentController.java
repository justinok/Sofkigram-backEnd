package com.justin.Sofkigram.controller;


import com.justin.Sofkigram.dto.CommentDTO;
import com.justin.Sofkigram.service.CommentService;
import com.justin.Sofkigram.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<?> createNewComment(@Valid CommentDTO newComment, BindingResult result){
        if (result.hasErrors()) {
            AtomicReference<String> message = new AtomicReference<>("");
            result.getAllErrors().forEach(objectError -> message.set(message + objectError.getDefaultMessage()));

            return new ResponseEntity<>(new ErrorMessage(message.toString()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(commentService.addNewComment(newComment), HttpStatus.CREATED)
                ;
    }

    @PutMapping
    public ResponseEntity<?> editComent(@Valid CommentDTO editedComment, BindingResult result){
        if (result.hasErrors()) {
            AtomicReference<String> message = new AtomicReference<>("");
            result.getAllErrors().forEach(objectError -> message.set(message + objectError.getDefaultMessage()));

            return new ResponseEntity<>(new ErrorMessage(message.toString()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(commentService.editComment(editedComment), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete")
    public void deleteComment(@RequestParam(name = "id") long targetId) {
        commentService.removeComment(targetId);
    }
}

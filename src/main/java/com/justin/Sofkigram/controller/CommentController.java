package com.justin.Sofkigram.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.justin.Sofkigram.dto.CommentLikesDTO;
import com.justin.Sofkigram.service.CommentServiceImplementation;
import com.justin.Sofkigram.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentServiceImplementation commentServiceImplementation;

    @PostMapping
    public ResponseEntity<?> createNewComment(@Valid CommentLikesDTO newComment, BindingResult result){
        if (result.hasErrors()) {
            AtomicReference<String> message = new AtomicReference<>("");
            result.getAllErrors().forEach(objectError -> message.set(message + objectError.getDefaultMessage()));

            return new ResponseEntity<>(new ErrorMessage(message.toString()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(commentServiceImplementation.addNewComment(newComment), HttpStatus.CREATED)
                ;
    }

    @PutMapping
    public ResponseEntity<?> editComent(@Valid CommentLikesDTO editedComment, BindingResult result){
        if (result.hasErrors()) {
            AtomicReference<String> message = new AtomicReference<>("");
            result.getAllErrors().forEach(objectError -> message.set(message + objectError.getDefaultMessage()));

            return new ResponseEntity<>(new ErrorMessage(message.toString()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(commentServiceImplementation.editComment(editedComment), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete")
    public void deleteComment(@RequestParam(name = "id") long targetId) {
        commentServiceImplementation.removeComment(targetId);
    }
}

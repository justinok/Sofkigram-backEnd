package com.justin.Sofkigram.controller;


import com.justin.Sofkigram.dto.UserLikeDTO;
import com.justin.Sofkigram.service.UserLikeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/like")
public class UserLikeController {
    @Autowired
    UserLikeServiceImplementation userLikeServiceImplementation;

    @PostMapping
    public int addNewLike(UserLikeDTO like) {
        return userLikeServiceImplementation.toggleLike(like);
    }
}

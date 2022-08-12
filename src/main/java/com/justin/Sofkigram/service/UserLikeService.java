package com.justin.Sofkigram.service;


import com.justin.Sofkigram.dto.UserLikeDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.entity.UserLike;
import com.justin.Sofkigram.mapper.UserLikeDTOMapper;
import com.justin.Sofkigram.repository.CommentRepository;
import com.justin.Sofkigram.repository.PostRepository;
import com.justin.Sofkigram.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLikeService {
    @Autowired
    UserLikeRepository userLikeRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserLikeDTOMapper userLikeDTOMapper;

    public int toggleLike(UserLikeDTO newLike) {
        Optional<UserLike> queryResult =  userLikeRepository.
                findByDni(newLike.getDni());

        UserLike targetLike = !queryResult.isEmpty() ? queryResult.get() : userLikeRepository.save(userLikeDTOMapper.dtoMapper(newLike));

        if (newLike.getPostId() != null) {
            Post targetPost = postRepository.findById(newLike.getPostId()).get();

            if (targetLike.containsPost(targetPost)) {
                targetLike.removePost(targetPost);
            } else {
                targetLike.addPost(targetPost);
            }

            userLikeRepository.save(targetLike);

            return targetPost.getNumberOfLikes();
        }

        Comment targetComment = commentRepository.findById(newLike.getCommentId()).get();

        if (targetLike.containsComment(targetComment)) {
            targetLike.removeComment(targetComment);
        } else {
            targetLike.addComment(targetComment);
        }

        userLikeRepository.save(targetLike);


        return targetComment.getNumberOfLikes();
    }
}

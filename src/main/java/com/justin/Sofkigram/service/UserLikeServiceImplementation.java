package com.justin.Sofkigram.service;


import com.justin.Sofkigram.dto.UserLikeDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.entity.UserLike;
import com.justin.Sofkigram.mapper.UserLikeDTOMapper;
import com.justin.Sofkigram.repository.ICommentRepository;
import com.justin.Sofkigram.repository.IPostRepository;
import com.justin.Sofkigram.repository.IUserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLikeServiceImplementation {
    @Autowired
    IUserLikeRepository IUserLikeRepository;

    @Autowired
    IPostRepository IPostRepository;

    @Autowired
    ICommentRepository ICommentRepository;

    @Autowired
    UserLikeDTOMapper userLikeDTOMapper;

    public int toggleLike(UserLikeDTO newLike) {
        Optional<UserLike> queryResult =  IUserLikeRepository.
                findByDni(newLike.getDni());

        UserLike targetLike = !queryResult.isEmpty() ? queryResult.get() : IUserLikeRepository.save(userLikeDTOMapper.dtoMapper(newLike));

        if (newLike.getPostId() != null) {
            Post targetPost = IPostRepository.findById(newLike.getPostId()).get();

            if (targetLike.containsPost(targetPost)) {
                targetLike.removePost(targetPost);
            } else {
                targetLike.addPost(targetPost);
            }

            IUserLikeRepository.save(targetLike);

            return targetPost.getNumberOfLikes();
        }

        Comment targetComment = ICommentRepository.findById(newLike.getCommentId()).get();

        if (targetLike.containsComment(targetComment)) {
            targetLike.removeComment(targetComment);
        } else {
            targetLike.addComment(targetComment);
        }

        IUserLikeRepository.save(targetLike);


        return targetComment.getNumberOfLikes();
    }
}

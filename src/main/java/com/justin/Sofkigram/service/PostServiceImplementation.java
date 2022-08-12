package com.justin.Sofkigram.service;


import com.justin.Sofkigram.dto.PostLikesDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.mapper.PostDTOMapper;
import com.justin.Sofkigram.repository.ICommentRepository;
import com.justin.Sofkigram.repository.IPostRepository;
import com.justin.Sofkigram.repository.IUserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation {
    @Autowired
    private IPostRepository IPostRepository;

    @Autowired
    private ICommentRepository ICommentRepository;

    @Autowired
    private IUserLikeRepository IUserLikeRepository;

    @Autowired
    private PostDTOMapper postDTOMapper;

    @Autowired
    private UserLikeServiceImplementation userLikeServiceImplementation;

    @Autowired
    private CommentServiceImplementation commentServiceImplementation;

    public List<PostLikesDTO> getAllPosts() {
        return IPostRepository.findAll().
                stream().map(postDTOMapper::postMapper).toList();
    }

    public PostLikesDTO addNewPost(PostLikesDTO newPost) {
        IPostRepository.save(postDTOMapper.dtoMapper(newPost));
        return newPost;
    }

    public PostLikesDTO editPost(PostLikesDTO updatedPost) {
        Post targetPost = IPostRepository.getReferenceById(updatedPost.getId());

        targetPost.setMessage(updatedPost.getMessage());
        targetPost.setTitle(updatedPost.getTitle());

        IPostRepository.save(targetPost);

        return updatedPost;
    }

    public void deletePost (long targetId) {
        Post targetPost = IPostRepository.getReferenceById(targetId);

        if (!targetPost.getLikes().isEmpty()) {
            targetPost.removeAllLikes();
        }

        if (!targetPost.getComments().isEmpty()) {
            for (Comment comment : targetPost.getComments()) {
                ICommentRepository.deleteById(comment.getId());
            }

            targetPost.removeAllComments();
        }

        IPostRepository.deleteById(targetId);
    }

}

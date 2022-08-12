package com.justin.Sofkigram.service;


import com.justin.Sofkigram.dto.PostDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.mapper.PostDTOMapper;
import com.justin.Sofkigram.repository.CommentRepository;
import com.justin.Sofkigram.repository.PostRepository;
import com.justin.Sofkigram.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserLikeRepository userLikeRepository;

    @Autowired
    private PostDTOMapper postDTOMapper;

    @Autowired
    private UserLikeService userLikeService;

    @Autowired
    private CommentService commentService;

    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().
                stream().map(postDTOMapper::postMapper).toList();
    }

    public PostDTO addNewPost(PostDTO newPost) {
        postRepository.save(postDTOMapper.dtoMapper(newPost));
        return newPost;
    }

    public PostDTO editPost(PostDTO updatedPost) {
        Post targetPost = postRepository.getReferenceById(updatedPost.getId());

        targetPost.setContent(updatedPost.getContent());
        targetPost.setTitle(updatedPost.getTitle());

        postRepository.save(targetPost);

        return updatedPost;
    }

    public void deletePost (long targetId) {
        Post targetPost = postRepository.getReferenceById(targetId);

        if (!targetPost.getLikes().isEmpty()) {
            targetPost.removeAllLikes();
        }

        if (!targetPost.getComments().isEmpty()) {
            for (Comment comment : targetPost.getComments()) {
                commentRepository.deleteById(comment.getId());
            }

            targetPost.removeAllComments();
        }

        postRepository.deleteById(targetId);
    }

}

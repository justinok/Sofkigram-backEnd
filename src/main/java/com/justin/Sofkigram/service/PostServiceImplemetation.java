package com.justin.Sofkigram.service;

import com.justin.Sofkigram.dto.PostDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.mapper.Mapper;
import com.justin.Sofkigram.repository.ICommentRepository;
import com.justin.Sofkigram.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImplemetation implements IPostService {

   @Autowired
   private IPostRepository postRepository;

   @Autowired
   private ICommentRepository commentRepository;

   @Autowired
   private Mapper mapper;


    @Override
    public PostDTO createPost(PostDTO post) {
        return mapper
                .fromEntityToPostDto(postRepository
                        .save(mapper.fromPostDtoToEntity(post)));
    }

    @Override
    public Post createComment(Comment comment) {
        Post post = postRepository.findById(comment.getFkPostId()).get();
        post.addComment(comment);
        commentRepository.save(comment);
        return postRepository.save(post);
    }



    @Override
    public void deleteComment(Comment comment) {
        commentRepository.deleteById(comment.getId());
    }

    @Override
    public void deletePost(Post post) {
        Post postToBeDeleted = postRepository.findById(post.getId()).get();
        if(postToBeDeleted.getComments().size() >= 0){
            postToBeDeleted.getComments().forEach(comment -> commentRepository.deleteById(comment.getId()));
        }
        postRepository.deleteById(post.getId());
    }

    @Override
    public List<PostDTO> findAllPosts() {
        var posts = postRepository.findAll();
        var postDTOs = posts.stream().map(post -> mapper.fromEntityToPostDto(post)).toList();
        return postDTOs;


    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) {
        return null;
    }
}

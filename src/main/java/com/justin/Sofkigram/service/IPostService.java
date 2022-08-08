package com.justin.Sofkigram.service;

import com.justin.Sofkigram.dto.PostDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;

import java.util.List;

public interface IPostService {



    Post createComment(Comment comment);



    void deleteComment(Comment comment);

    void deletePost(Post post);



    PostDTO createPost (PostDTO post);

    List<PostDTO> findAllPosts ();
    PostDTO updatePost(PostDTO postDTO) ;

}

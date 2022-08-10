package com.justin.Sofkigram.service;

import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;

import java.util.List;

public interface IPostService {

    Post createPost(Post post);

    Post createComment(Comment comment);
    


    void deleteComment(Comment comment);

    void deletePost(Post post);

    List<Post> findAllPosts();
}

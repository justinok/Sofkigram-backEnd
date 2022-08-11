package com.justin.Sofkigram.service;

import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Like;
import com.justin.Sofkigram.entity.Post;

import java.util.List;

public interface IPostService {

    Post createPost(Post post);

    Post createComment(Comment comment);
    Post createLike(Like like);


    void deleteComment(Comment comment);

    void deletePost(Post post);

    void deleteLike(Like like);

    List<Post> findAllPosts();
}

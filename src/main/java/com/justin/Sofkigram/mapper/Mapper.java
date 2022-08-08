package com.justin.Sofkigram.mapper;

import com.justin.Sofkigram.dto.PostDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Post fromPostDtoToEntity(PostDTO dto) {
        var post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setMessage(dto.getMessage());
        post.setNumberOfLikes(dto.getNumberOfLikes());
        post.setUserLikes(dto.getUserLikes());
        post.setComments(dto.getComments());

        return post;
    }

    public PostDTO fromEntityToPostDto(Post entity) {
        var postDto = new PostDTO();
        postDto.setId(entity.getId());
        postDto.setTitle(entity.getTitle());
        postDto.setMessage(entity.getMessage());
        postDto.setNumberOfLikes(entity.getNumberOfLikes());
        postDto.setUserLikes(entity.getUserLikes());
        postDto.setComments(entity.getComments());
        return postDto;
    }

    public Comment fromCommentDtoToEntity(CommentDTO dto) {
        var comment = new Comment();
        comment.setId(dto.getId());
        comment.setContent(dto.getContent());
        comment.setNumberOfLikes(dto.getNumberOfLikes());
        comment.setUserLikes(dto.getUserLikes());
        comment.setFkPost(dto.getFkPost());
        return comment;
    }

    public CommentDTO fromEntityToCommentDto(Comment entity) {
        var commentDto = new CommentDTO();
        commentDto.setId(entity.getId());
        commentDto.setContent(entity.getContent());
        commentDto.setNumberOfLikes(entity.getNumberOfLikes());
        commentDto.setUserLikes(entity.getUserLikes());
        commentDto.setFkPost(entity.getFkPost());
        return commentDto;
    }

    public UserLike fromUserLikeDtoToEntity(UserLikeDTO dto) {
        var userlike = new UserLike();
        userlike.setId(dto.getId());
        userlike.setDni(dto.getDni());
        userlike.setUserName(dto.getUserName());
        userlike.setPosts(dto.getPosts());
        userlike.setComments(dto.getComments());
        return userlike;
    }

    public UserLikeDTO fromEntityToUserLikeDto(UserLike entity) {
        var userlikeDto = new UserLikeDTO();
        userlikeDto.setId(entity.getId());
        userlikeDto.setDni(entity.getDni());
        userlikeDto.setUserName(entity.getUserName());
        userlikeDto.setPosts(entity.getPosts());
        userlikeDto.setComments(entity.getComments());
        return userlikeDto;
    }

    public Post updateExistingPost(Post oldPost, PostDTO newPost) {
        var newPostTitle = newPost.getTitle();
        var newPostContent = newPost.getContent();
        var newPostNumberOfLikes = newPost.getNumberOfLikes();

        if (newPostTitle != null) {
            oldPost.setTitle(newPostTitle);
        }

        if (newPostContent != null) {
            oldPost.setContent(newPostContent);
        }

        if (newPostNumberOfLikes != null) {
            oldPost.setNumberOfLikes(newPostNumberOfLikes);
        }

        return oldPost;
    }
}
}

package com.justin.Sofkigram.mapper;


import com.justin.Sofkigram.dto.CommentLikesDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CommentDTOMapper {

    @Autowired
    UserLikeDTOMapper userLikeDTOMapper;

    public CommentLikesDTO commentMapper(Comment comment) {
        CommentLikesDTO commentDTO = new CommentLikesDTO();

        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getMessage());
        commentDTO.setPostId(comment.getPost().getId());

        commentDTO.setLikes(comment.getLikes().stream().map(userLikeDTOMapper::userLikeMapper).toList());

        commentDTO.setNumberOfLikes();

        return commentDTO;
    }

    public Comment dtoToEntity(CommentLikesDTO commentDTO, Post commentPost) {
        Comment comment = new Comment();

        comment.setMessage(commentDTO.getContent());
        comment.setPost(commentPost);

        return comment;
    }
}

package com.justin.Sofkigram.mapper;


import com.justin.Sofkigram.dto.CommentDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CommentDTOMapper {

    @Autowired
    UserLikeDTOMapper userLikeDTOMapper;

    public CommentDTO commentMapper(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setPostId(comment.getPost().getId());

        commentDTO.setLikes(comment.getLikes().stream().map(userLikeDTOMapper::userLikeMapper).toList());

        commentDTO.setNumberOfLikes();

        return commentDTO;
    }

    public Comment dtoToEntity(CommentDTO commentDTO, Post commentPost) {
        Comment comment = new Comment();

        comment.setContent(commentDTO.getContent());
        comment.setPost(commentPost);

        return comment;
    }
}

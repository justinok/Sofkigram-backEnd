package com.justin.Sofkigram.service;


import com.justin.Sofkigram.dto.CommentLikesDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.mapper.CommentDTOMapper;
import com.justin.Sofkigram.repository.ICommentRepository;
import com.justin.Sofkigram.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation {
    @Autowired
    private ICommentRepository ICommentRepository;

    @Autowired
    private IPostRepository IPostRepository;

    @Autowired
    private CommentDTOMapper commentDTOMapper;

    public CommentLikesDTO addNewComment(CommentLikesDTO newComment) {
        Post parentPost = IPostRepository.findById(newComment.getPostId()).get();

        Comment processedComment = commentDTOMapper.dtoToEntity(newComment, parentPost);

        parentPost.addComment(processedComment);

        ICommentRepository.save(processedComment);

        return newComment;
    }

    public CommentLikesDTO editComment(CommentLikesDTO updatedComment) {
        Comment targetComment = ICommentRepository.getReferenceById(updatedComment.getId());

        targetComment.setMessage(updatedComment.getContent());

        ICommentRepository.save(targetComment);

        return updatedComment;
    }

    public void removeComment(long targetId) {
        ICommentRepository.deleteById(targetId);
    }
}
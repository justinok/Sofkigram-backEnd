package com.justin.Sofkigram.service;


import com.justin.Sofkigram.dto.CommentDTO;
import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.mapper.CommentDTOMapper;
import com.justin.Sofkigram.repository.CommentRepository;
import com.justin.Sofkigram.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentDTOMapper commentDTOMapper;

    public CommentDTO addNewComment(CommentDTO newComment) {
        Post parentPost = postRepository.findById(newComment.getPostId()).get();

        Comment processedComment = commentDTOMapper.dtoToEntity(newComment, parentPost);

        parentPost.addComment(processedComment);

        commentRepository.save(processedComment);

        return newComment;
    }

    public CommentDTO editComment(CommentDTO updatedComment) {
        Comment targetComment = commentRepository.getReferenceById(updatedComment.getId());

        targetComment.setContent(updatedComment.getContent());

        commentRepository.save(targetComment);

        return updatedComment;
    }

    public void removeComment(long targetId) {
        commentRepository.deleteById(targetId);
    }
}
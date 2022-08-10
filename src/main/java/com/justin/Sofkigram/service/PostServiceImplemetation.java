package com.justin.Sofkigram.service;

import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Like;
import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.repository.ICommentRepository;
import com.justin.Sofkigram.repository.ILikeRepository;
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
   private ILikeRepository likeRepository;




    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
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
        if(postToBeDeleted.getLikes().size() >= 0){
            postToBeDeleted.getLikes().forEach(like -> likeRepository.deleteById(like.getId()));
        }
        postRepository.deleteById(post.getId());
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    /**
     * like
     * @param like
     * @return
     */
    @Override
    public Post createLike(Like like) {
        Post post = postRepository.findById(like.getFkPostId()).get();
        post.addLike(like);
        likeRepository.save(like);
        return postRepository.save(post);
    }


    @Override
    public void deleteLike(Like like) {
        likeRepository.deleteById(like.getId());

    }
}

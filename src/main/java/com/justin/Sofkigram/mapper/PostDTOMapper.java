package com.justin.Sofkigram.mapper;


import com.justin.Sofkigram.dto.PostDTO;
import com.justin.Sofkigram.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostDTOMapper {

    @Autowired
    CommentDTOMapper commentDTOMapper;

    @Autowired
    UserLikeDTOMapper userLikeDTOMapper;

    /* This and the Comment mapper could inherit from an abstract class or interface, as their methods are virtually identical. However,
    it's not possible to create an instance of an abstract class (DTOMapper). Find a way to prevent this repetition.
    * */

    public PostDTO postMapper(Post post) {
        PostDTO postDTO = new PostDTO();

        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());

        postDTO.setContent(post.getContent());

        postDTO.setComments(post.getComments().stream().map(commentDTOMapper::commentMapper).toList());
        postDTO.setLikes(post.getLikes().stream().map(userLikeDTOMapper::userLikeMapper).toList());

        postDTO.setNumberOfLikes();

        return postDTO;
    }

    public Post dtoMapper(PostDTO postDTO) {
        Post post = new Post();

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        return post;
    }
}

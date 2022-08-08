package com.justin.Sofkigram.dto;

import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.entity.UserLike;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.validation.constraints.Size;
@Data
public class CommentDTO {
    private Integer id;
    @Size(min=10, max = 255, message = "Error the number of characters must be min 10 max 255")
    private String message;
    private Integer numberOfLikes=0;
    private Post fkPost;//
    private Set<UserLike> userLikes = new LinkedHashSet<>();

}

package com.justin.Sofkigram.dto;

import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.UserLike;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
public class PostDTO {
    private Integer id;
    @Size(min=5, max = 50, message = "Error the number of characters must be min 5 max 50")
    private String title;
    @Size(min=10, max = 100, message = "Error the number of characters must be min 10 max 100")
    private String message;
    private Integer numberOfLikes=0;
    private Set<UserLike> userLikes = new LinkedHashSet<>();
    private Set<Comment> comments = new LinkedHashSet<>();

}

package com.justin.Sofkigram.dto;

import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Post;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class UserLikeDTO {

    private Integer id;
    @Size(min=10, max = 50, message = "Error the number of characters must be min 10 max 50")
    private String userName;
    @Size(min=8, max = 20, message = "Error the number of characters must be min 8 max 20")
    private String dni;
    private Set<Comment> comments = new LinkedHashSet<>();
    private Set<Post> posts = new LinkedHashSet<>();
}

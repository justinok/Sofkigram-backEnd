package com.justin.Sofkigram.dto;


import lombok.Data;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostLikesDTO extends LikesDTO {

    @Size(min = 5, max = 50, message =
            "The title must be in the range of 5 and 50 characters!")
    private String title;

    @Size(min = 10, max = 255, message =
            "The message must be in the range of 5 and 50 characters")
    private String message;
    List<CommentLikesDTO> comments = new ArrayList<>();

    public void setComments(List<CommentLikesDTO> postComments) {
        this.comments.addAll(postComments);
    }


}

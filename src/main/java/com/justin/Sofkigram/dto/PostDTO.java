package com.justin.Sofkigram.dto;


import lombok.Data;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostDTO extends DTOBlueprint {

    @Size(min = 5, max = 50, message = "Adjust your title's length.")
    private String title;

    @Size(min = 10, max = 255, message = "Adjust your content's length.")
    private String content;
    List<CommentDTO> comments = new ArrayList<>();

    public void setComments(List<CommentDTO> postComments) {
        this.comments.addAll(postComments);
    }


}

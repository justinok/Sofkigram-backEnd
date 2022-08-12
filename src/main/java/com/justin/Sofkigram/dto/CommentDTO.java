package com.justin.Sofkigram.dto;


import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class CommentDTO extends DTOBlueprint {
    private long postId;

    @Size(min = 10, max = 255, message = "Adjust your content's length.")
    private String content;

}

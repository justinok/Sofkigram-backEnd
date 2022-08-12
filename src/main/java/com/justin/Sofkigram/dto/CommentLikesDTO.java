package com.justin.Sofkigram.dto;


import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class CommentLikesDTO extends LikesDTO {
    private long postId;

    @Size(min = 10, max = 255, message = "Adjust your message's length.")
    private String content;

}

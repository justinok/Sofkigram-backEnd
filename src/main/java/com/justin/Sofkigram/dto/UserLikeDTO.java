package com.justin.Sofkigram.dto;

import lombok.Data;


@Data
public class UserLikeDTO {
    private long id;
    private String userName;
    private String dni;

    private Long postId;
    private Long commentId;

}

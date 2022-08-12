package com.justin.Sofkigram.dto;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class UserLikeDTO {
    private long id;
    private String userName;
    private String dni;

    private Long postId;
    private Long commentId;

}

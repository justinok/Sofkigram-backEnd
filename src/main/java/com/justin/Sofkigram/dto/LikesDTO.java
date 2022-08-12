package com.justin.Sofkigram.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class LikesDTO {
    private long id;

    private int numberOfLikes;

    private List<UserLikeDTO> likes = new ArrayList<>();

    public void setLikes(List<UserLikeDTO> likes) {
        this.likes.addAll(likes);
    }

    public void setNumberOfLikes() {
        this.numberOfLikes = likes.size();
    }
}
package com.justin.Sofkigram.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Comment")
@Table(name = "comment")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id", nullable = false)
    private Post post;

    @ManyToMany(mappedBy = "likedComments")
    private List<UserLike> likes = new ArrayList<>();

    public void addLike(UserLike newLike) {
        this.likes.add(newLike);
    }

    public void removeLike (UserLike targetLike) {
        this.likes.remove(targetLike);
    }

    public int getNumberOfLikes(){
        return this.likes.size();
    }
}

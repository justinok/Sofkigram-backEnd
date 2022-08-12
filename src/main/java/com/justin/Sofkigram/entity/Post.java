package com.justin.Sofkigram.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Post")
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(mappedBy = "likedPosts", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<UserLike> likes = new ArrayList<>();

    public void addComment(Comment newComment) {
        this.comments.add(newComment);
    }

    public void removeComment(Comment targetComment) {
        this.comments.remove(targetComment);
    }

    public void addLike(UserLike newLike) {
        this.likes.add(newLike);
    }

    public void removeLike(UserLike targetLike) {
        this.likes.remove(targetLike);
    }

    public void removeAllLikes() {
        this.likes.removeAll(likes);
    }

    public void removeAllComments() {
        this.comments.removeAll(comments);
    }

    public int getNumberOfLikes(){
        return this.likes.size();
    }
}

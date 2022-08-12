package com.justin.Sofkigram.entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "UserLike")
@Table(name = "user_likes")
@Data
public class UserLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;
    private String dni;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name="post_like",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="post_id")
    )
    private List<Post> likedPosts = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name="comment_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    private List<Comment> likedComments = new ArrayList<>();

    public void addPost(Post newPost) {
        this.likedPosts.add(newPost);
        newPost.addLike(this);
    }

    public void removePost(Post targetPost){
        this.likedPosts.remove(targetPost);
    }

    public boolean containsPost(Post targetPost) {
        return this.likedPosts.contains(targetPost);
    }

    public void addComment(Comment newComment) {
        this.likedComments.add(newComment);
    }

    public void removeComment(Comment targetComment) {
        this.likedComments.remove(targetComment);
    }

    public boolean containsComment(Comment targetComment) {
        return this.likedComments.contains(targetComment);
    }
}

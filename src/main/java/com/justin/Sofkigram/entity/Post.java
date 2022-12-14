package com.justin.Sofkigram.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 *  The intention of this class is to connect with MySQL and mre specifically
 *  to connect with post table inside our Schema, so we call it a entity and
 *  wire all the columns inside
 *
 * @onetomany is a spring anotation to relate the two tables inside this
 *            project and create the one post/multiple comments relationship
 *
 * @author Justin Diaz - jusadiazjim@unal.edu.co
 * @since 1.0
 * @version 3.4.1
 */
@Entity(name = "Post")
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    private String title;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Comment> comments = new ArrayList<>();

    public  Post addComment(Comment comment){
        this.comments.add(comment);

        return this;
    }



}

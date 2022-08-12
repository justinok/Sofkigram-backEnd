package com.justin.Sofkigram.entity;
/**
 * happy boy
 */

import lombok.Data;

import javax.persistence.*;

/**
 *  The intention of this class is to connect with MySQL and mre specifically
 *  to connect with comment table inside our Schema, so we call it a entity and
 *  wire all the columns insidea
 *  adadadad
 *
 * @author Justin Diaz - jusadiazjim@unal.edu.co
 * @since 1.0
 * @version 3.4.1
 */

@Entity(name = "Comment")
@Table(name = "comment")
@Data
public class Comment {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    private Long fkPostId;
}

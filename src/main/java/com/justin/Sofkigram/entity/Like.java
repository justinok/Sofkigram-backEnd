package com.justin.Sofkigram.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Like")
@Table(name = "like")
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String DNI;

    private Long fkPostId;
}

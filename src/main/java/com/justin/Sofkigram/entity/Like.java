package com.justin.Sofkigram.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table( name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String DNI;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
    mappedBy = "likes")
    private Set<Post> posts = new HashSet<>();


    public Like(){

    }
    public Like(String name, String DNI) {
        super();
        this.name = name;
        this.DNI = DNI;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}

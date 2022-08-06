package com.justin.Sofkigram.repository;

import com.justin.Sofkigram.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {
}

package com.justin.Sofkigram.repository;

import com.justin.Sofkigram.entity.Comment;
import com.justin.Sofkigram.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepository extends JpaRepository<Like, Long> {
}

package com.justin.Sofkigram.repository;

import com.justin.Sofkigram.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
}

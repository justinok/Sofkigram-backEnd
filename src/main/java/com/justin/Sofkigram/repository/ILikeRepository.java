package com.justin.Sofkigram.repository;

import com.justin.Sofkigram.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepository extends JpaRepository<Like,Long> {
}

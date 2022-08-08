package com.justin.Sofkigram.repository;

import com.justin.Sofkigram.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserLikeRepository extends JpaRepository<UserLike, Integer> {
}
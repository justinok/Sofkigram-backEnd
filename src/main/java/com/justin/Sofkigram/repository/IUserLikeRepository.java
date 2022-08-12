package com.justin.Sofkigram.repository;


import com.justin.Sofkigram.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserLikeRepository extends JpaRepository<UserLike, Long> {
    Optional<UserLike> findByDni(String dni);
}

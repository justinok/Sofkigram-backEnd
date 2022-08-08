package com.justin.Sofkigram.repository;

import com.justin.Sofkigram.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *  The intention of this interface is to extend from the jpa repository
 *
 * @author Justin Diaz - jusadiazjim@unal.edu.co
 * @since 2.0
 * @version 3.4.1
 */
@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
}

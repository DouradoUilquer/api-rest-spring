package com.connectsoftware.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectsoftware.osworks.domain.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}

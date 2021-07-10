package com.hh99.adassignment.repository;

import com.hh99.adassignment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

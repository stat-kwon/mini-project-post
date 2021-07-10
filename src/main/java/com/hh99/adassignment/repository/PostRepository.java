package com.hh99.adassignment.repository;

import com.hh99.adassignment.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

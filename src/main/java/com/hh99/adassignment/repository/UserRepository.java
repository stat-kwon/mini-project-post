package com.hh99.adassignment.repository;

import com.hh99.adassignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

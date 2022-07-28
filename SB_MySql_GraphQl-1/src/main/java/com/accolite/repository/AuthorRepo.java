package com.accolite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Long>{

}

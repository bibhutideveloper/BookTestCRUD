package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
}

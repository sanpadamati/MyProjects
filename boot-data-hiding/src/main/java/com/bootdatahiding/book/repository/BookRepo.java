package com.bootdatahiding.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootdatahiding.model.book.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
	
	
}

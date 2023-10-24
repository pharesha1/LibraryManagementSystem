package com.example.librarymanagementsystem.dao;

import com.example.librarymanagementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//book repository extends jpa repository to get the basic crud functions for the application
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByOrderByTitleAsc();
}

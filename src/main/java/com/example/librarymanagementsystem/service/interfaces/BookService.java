package com.example.librarymanagementsystem.service.interfaces;

import com.example.librarymanagementsystem.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    Book saveBook(Book book);
    void deleteBook(int id);
}

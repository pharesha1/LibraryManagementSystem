package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dao.BookRepository;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.interfaces.BookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//book api service
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository theBookRepository) {
        this.bookRepository = theBookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> result = bookRepository.findById(id);

        Book dbBook = null;
        if (result.isPresent()){
            dbBook=result.get();
        }else{
            throw new RuntimeException("Could not find book by Id: " + id);
        }

        return dbBook;
    }
    @Override
    @Transactional
    public Book saveBook(Book theBook) {
        return bookRepository.save(theBook);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}

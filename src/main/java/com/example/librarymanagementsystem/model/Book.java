package com.example.librarymanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;
    @Column(name = "title")
    @NotNull(message = "Title Is Required!")
    @Size(min = 1, message = "Title Is Required!")
    private String title;
    @NotNull(message = "Author Is Required!")
    @Size(min = 1, message = "Author Is Required!")
    @Column(name = "author")
    private String author;
    @NotNull(message = "isbn Is Required!")
    @Size(min = 9, max = 13, message = "isbn must be between 9 and 13 characters!")
    @Column(name = "isbn")
    private String isbn;
    @NotNull(message = "Genre Is Required!")
    @Size(min = 1, message = "Genre Is Required!")
    @Column(name = "genre")
    private String genre;
    @NotNull(message = "Available Copies is Required!")
    @Column(name = "available_copies")
    private int availableCopies;
    @NotNull(message = "Available Copies is Required!")
    @Column(name = "total_copies")
    private int totalCopies;

    public Book(String title, String author, String isbn, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
    }

    public Book(String title, String author, String isbn, String genre, int totalCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.totalCopies = totalCopies;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }
}

package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.interfaces.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/manage")
    public String bookIndex(Model model){
        model.addAttribute("bookList", bookService.getAllBooks());

        return "book/manage";
    }

    @GetMapping("/createForm")
    public String bookForm(Model model){
        model.addAttribute("book", new Book());

        return "book/form";
    }

    @PostMapping("/save")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "book/form";
        }else {
            bookService.saveBook(book);
            return "redirect:/books/manage";
        }
    }

    @GetMapping("/updateForm")
    public String updateBook(@RequestParam("bookId") int bookId, Model model){
        Book dbBook = bookService.getBookById(bookId);
        model.addAttribute(dbBook);
        return "book/form";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int bookId){
        bookService.deleteBook(bookId);
        return "redirect:/books/manage";
    }

    @InitBinder
    public void initBinder (WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}

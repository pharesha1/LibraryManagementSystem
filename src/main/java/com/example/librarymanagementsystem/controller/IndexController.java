package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.interfaces.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class IndexController {

    private BookService bookService;

    public IndexController(BookService theBookService) {
        this.bookService = theBookService;
    }

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute(bookService.getAllBooks());

        return "index";
    }
}

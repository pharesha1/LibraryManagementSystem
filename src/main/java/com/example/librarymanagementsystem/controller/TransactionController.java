package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Transaction;
import com.example.librarymanagementsystem.service.interfaces.BookService;
import com.example.librarymanagementsystem.service.interfaces.PatronService;
import com.example.librarymanagementsystem.service.interfaces.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionService transactionService;
    private BookService bookService;
    private PatronService patronService;

    public TransactionController(TransactionService transactionService, BookService bookService, PatronService patronService) {
        this.transactionService = transactionService;
        this.bookService = bookService;
        this.patronService = patronService;
    }

    @GetMapping("/manage")
    public String transactionList(Model model){
        model.addAttribute("transactionList", transactionService.getAllTransactions());

        return "transaction/manage";
    }

    @GetMapping("/createForm")
    public String transactionForm(Model model){
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("booksList", bookService.getAllBooks());
        model.addAttribute("patronsList", patronService.getAllPatrons());

        return "transaction/form";
    }

    @PostMapping("/save")
    public String createTransaction(@Valid @ModelAttribute("transaction") Transaction transaction, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect: /transactions/showCreateForm";
        }else {
            transactionService.saveTransaction(transaction);
            return "redirect:/transactions/list";
        }
    }

    @GetMapping("/showUpdateForm")
    public String updateTransaction(@RequestParam("transactionId") int transactionId, Model model){
        Transaction dbTransaction = transactionService.getTransactionById(transactionId);
        model.addAttribute(dbTransaction);
        return "transaction/form";
    }

    @GetMapping("/delete")
    public String deleteTransaction(@RequestParam("transactionId") int transactionId){
        transactionService.deleteTransaction(transactionId);
        return "redirect:/transactions/list";
    }

    @InitBinder
    public void initBinder (WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}

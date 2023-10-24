package com.example.librarymanagementsystem.service.interfaces;

import com.example.librarymanagementsystem.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(int id);
    Transaction saveTransaction(Transaction transaction);
    void deleteTransaction(int id);
}

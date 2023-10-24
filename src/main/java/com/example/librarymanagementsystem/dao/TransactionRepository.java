package com.example.librarymanagementsystem.dao;

import com.example.librarymanagementsystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}

package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dao.TransactionRepository;
import com.example.librarymanagementsystem.model.Transaction;
import com.example.librarymanagementsystem.service.interfaces.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository theTransactionRepository) {
        this.transactionRepository = theTransactionRepository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(int id) {
        Optional<Transaction> result = transactionRepository.findById(id);

        Transaction dbTransaction = null;
        if (result.isPresent()){
            dbTransaction=result.get();
        }else{
            throw new RuntimeException("Could not find transaction by Id: " + id);
        }

        return dbTransaction;
    }
    @Override
    @Transactional
    public Transaction saveTransaction(Transaction theTransaction) {
        return transactionRepository.save(theTransaction);
    }

    @Override
    @Transactional
    public void deleteTransaction(int id) {
        transactionRepository.deleteById(id);
    }
}

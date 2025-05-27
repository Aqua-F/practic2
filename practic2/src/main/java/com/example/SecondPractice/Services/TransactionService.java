package com.example.SecondPractice.Services;

import com.example.SecondPractice.DAO.TransactionDAO;
import com.example.SecondPractice.Entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionDAO transactionDAO;

    @Autowired
    public TransactionService(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public void saveTransaction(Transaction transaction) {
        transactionDAO.saveTransaction(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }

    public List<Transaction> getTransactionsByUserId(int id) {
        return transactionDAO.findTransactionsByUserId(id);
    }

    public List<Transaction> getTransactionsByAccountId(int id) {
        return transactionDAO.findTransactionsByAccountFromId(id);
    }
}

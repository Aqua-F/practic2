package com.example.SecondPractice.DAO;

import com.example.SecondPractice.Entities.Transaction;
import com.example.SecondPractice.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAO {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionDAO(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    //Сохранение сущности в базу
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    //Поиск сущности по полю
    public Transaction findTransactionById(int id) {
        return transactionRepository.findById(id).get();
    }

    //Поиск всех сущностей по условию
    public List<Transaction> findTransactionsByUserId(int userId) {
        return transactionRepository.findByUserId(userId);
    }

    public List<Transaction> findTransactionsByAccountFromId(int accountFromId) {
        return transactionRepository.findByAccountFromId(accountFromId);
    }

    public List<Transaction> findTransactionsByAccountToId(int accountToId) {
        return transactionRepository.findByAccountToId(accountToId);
    }

    //Удаление сущности по условию
    public void deleteTransactionById(int id) {
        transactionRepository.deleteById(id);
    }

    public void deleteTransactionsByUserId(int userId) {
        transactionRepository.deleteByUserId(userId);
    }

    public void deleteTransactionsByAccountFromId(int accountFromId) {
        transactionRepository.deleteByAccountFromId(accountFromId);
    }

    public void deleteTransactionsByAccountToId(int accountToId) {
        transactionRepository.deleteByAccountToId(accountToId);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}

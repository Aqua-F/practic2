package com.example.SecondPractice.Repositories;

import com.example.SecondPractice.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByUserId(int userId);
    List<Transaction> findByAccountFromId(int accountFromId);
    List<Transaction> findByAccountToId(int accountToId);

    void deleteByUserId(int userId);
    void deleteByAccountFromId(int accountFromId);
    void deleteByAccountToId(int accountToId);
}

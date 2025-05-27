package com.example.SecondPractice.DAO;

import com.example.SecondPractice.Entities.Account;
import com.example.SecondPractice.Entities.Transaction;
import com.example.SecondPractice.Repositories.AccountRepository;
import com.example.SecondPractice.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAO {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountDAO(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //Сохранение сущности в базу
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    //Поиск сущности по полю
    public Account findAccountById(int id) {
        return accountRepository.findById(id).get();
    }

    //Поиск всех сущностей по условию
    public List<Account> findAccountsByUserId(int userId) {
        return accountRepository.findByUserId(userId);
    }

    //Удаление сущности по условию
    public void deleteAccountById(int id) {
        accountRepository.deleteById(id);
    }

    public void deleteAccountsByUserId(int userId) {
        accountRepository.deleteByUserId(userId);
    }
}

package com.example.SecondPractice.Services;

import com.example.SecondPractice.DAO.AccountDAO;
import com.example.SecondPractice.Entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void saveAccount(Account account) {
        accountDAO.saveAccount(account);
    }

    public void deleteAccountById(int id) {
        accountDAO.deleteAccountById(id);
    }

    public Account findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }
}

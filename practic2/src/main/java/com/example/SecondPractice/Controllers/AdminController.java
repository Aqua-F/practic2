package com.example.SecondPractice.Controllers;

import com.example.SecondPractice.Entities.Account;
import com.example.SecondPractice.Entities.Transaction;
import com.example.SecondPractice.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    TransactionService transactionService;

    @Autowired
    public AdminController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    //Вывод всех транзакций
    @GetMapping("/getTransactions")
    public ResponseEntity<List<Transaction>> getTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    //Вывод всех транзакций пользователя
    @GetMapping("/getTransactionsByUserId/{id}")
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(@PathVariable int id) {
        return ResponseEntity.ok(transactionService.getTransactionsByUserId(id));
    }

    //Вывод всех транзакций Аккаунта
    @GetMapping("/getTransactionsByAccountId/{id}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountId(@PathVariable int id) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccountId(id));
    }
}

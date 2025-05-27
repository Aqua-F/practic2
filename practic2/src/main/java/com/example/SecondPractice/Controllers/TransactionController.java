package com.example.SecondPractice.Controllers;

import com.example.SecondPractice.DTO.AuthRequest;
import com.example.SecondPractice.DTO.TransmissionRequest;
import com.example.SecondPractice.Entities.Transaction;
import com.example.SecondPractice.Services.AccountService;
import com.example.SecondPractice.Services.TransactionService;
import com.example.SecondPractice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final UserService userService;
    private final AccountService accountService;

    @Autowired
    public TransactionController(TransactionService transactionService, UserService userService, AccountService accountService) {
        this.transactionService = transactionService;
        this.userService = userService;
        this.accountService = accountService;
    }

    //Перевод денег
    @PostMapping("/transmit")
    public ResponseEntity<String> transmit(@RequestBody TransmissionRequest request) {
        boolean success = (accountService.findAccountById(request.getAccountFromId()) != null) && (accountService.findAccountById(request.getAccountToId()) != null);

        if (!success) return ResponseEntity.status(401).body("User not found");

        Transaction newTransaction = new Transaction();
        newTransaction.setUser(userService.findUserById(accountService.findAccountById(request.getAccountFromId()).getUser()));
        newTransaction.setPayload(request.getPayload());
        newTransaction.setAccountFrom(accountService.findAccountById(request.getAccountFromId()));
        newTransaction.setAccountTo(accountService.findAccountById(request.getAccountToId()));

        transactionService.saveTransaction(newTransaction);

        return ResponseEntity.ok("Transaction successful");
    }
}

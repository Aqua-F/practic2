package com.example.SecondPractice.Controllers;

import com.example.SecondPractice.DAO.AccountDAO;
import com.example.SecondPractice.DTO.OpenAccountRequest;
import com.example.SecondPractice.Entities.Account;
import com.example.SecondPractice.Entities.User;
import com.example.SecondPractice.Services.AccountService;
import com.example.SecondPractice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private final UserService userService;

    @Autowired
    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    //Открытие счета
    @PostMapping("/open/{userId}")
    public ResponseEntity<String> openAccount(@PathVariable int userId, @RequestBody OpenAccountRequest request) {
        User user = userService.findUserById(userId);

        if (user == null) return ResponseEntity.badRequest().body("User not found");

        Account newAccount = new Account();
        newAccount.setUser(user);
        newAccount.setBalance(request.getBalance());
        newAccount.setOverdraft(request.getIsOverdraft());

        accountService.saveAccount(newAccount);
        return ResponseEntity.ok("Account opened successfully");
    }

    //Закрытие счета
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> closeAccount(@PathVariable int id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.ok("Account closed successfully");
    }

    //Просмотр данных о счете
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable int id) {
        Account account = accountService.findAccountById(id);
        return ResponseEntity.ok(account);
    }
}

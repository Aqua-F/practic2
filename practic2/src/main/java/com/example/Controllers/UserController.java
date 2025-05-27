package com.example.Controllers;

import com.example.DTO.AuthRequest;
import com.example.Entities.User;
import com.example.Security.JwtUtil;
import com.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // Авторизация пользователя
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        boolean success = userService.authenticateUser(request.getEmail(), request.getPassword());

        if (success) {
            String token = jwtUtil.generateToken(userService.findUserByEmail(request.getEmail()));
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    // Регистрация пользователя
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        boolean exists = userService.userExists(request.getEmail());

        if (exists) return ResponseEntity.badRequest().body("User already exists");

        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());
        newUser.setRole("USER");
        newUser.setRegistrationDate(LocalDate.now());

        userService.saveUser(newUser);
        String token = jwtUtil.generateToken(newUser);
        return ResponseEntity.ok(token); // Возвращаем токен после регистрации
    }

    // Удаление пользователя
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        boolean deleted = userService.deleteUserById(id);

        if (deleted) return ResponseEntity.ok("User deleted");
        return ResponseEntity.notFound().build();
    }
}

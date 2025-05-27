package com.example.SecondPractice.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "balance", nullable = false)
    private int balance;

    @Column(name = "is_overdraft", nullable = false)
    private boolean isOverdraft;

    @OneToMany(mappedBy = "accountFrom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> outgoingTransactions;

    @OneToMany(mappedBy = "accountTo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> incomingTransactions;

    //Сеттеры
    public void setUser(User user) {
        this.user = user;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setOverdraft(boolean isOverdraft) {
        this.isOverdraft = isOverdraft;
    }

    //Геттеры
    public int getId() {
        return id;
    }

    public int getUser() {
        return user.getId();
    }

    public int getBalance() {
        return balance;
    }

    public boolean getIsOverdraft() {
        return isOverdraft;
    }
}

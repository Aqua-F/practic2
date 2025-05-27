package com.example.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    //@Column(name = "account_from_id", nullable = false)
    //private int accountFromId;
    @ManyToOne
    @JoinColumn(name = "account_from_id", nullable = false)
    private Account accountFrom;

    //@Column(name = "user_id", nullable = false)
    //private int userId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "payload", nullable = false)
    private int payload;

    //@Column(name = "account_to_id", nullable = false)
    //private int accountToId;
    @ManyToOne
    @JoinColumn(name = "account_to_id", nullable = false)
    private Account accountTo;

    //Сеттеры
    public void setUser(User user) {
        this.user = user;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }

    //Геттеры
    public int getId() {
        return id;
    }

    public int getAccountFrom() {
        return accountFrom.getId();
    }

    public int getUser() {
        return user.getId();
    }

    public int getAccountTo() {
        return accountTo.getId();
    }

    public int getPayload() {
        return payload;
    }
}
package com.example.DTO;

import lombok.Data;

@Data
public class OpenAccountRequest {
    private int balance;
    private boolean isOverdraft;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setIsOverdraft(boolean isOverdraft) {
        this.isOverdraft = isOverdraft;
    }

    public int getBalance() {
        return balance;
    }

    public boolean getIsOverdraft() {
        return isOverdraft;
    }
}

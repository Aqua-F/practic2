package com.example.SecondPractice.DTO;

import lombok.Data;

@Data
public class TransmissionRequest {
    private int accountFromId;
    private int accountToId;
    private int payload;

    public void setAccountFromId(int accountFromId) {
        this.accountFromId = accountFromId;
    }

    public void setAccountToId(int accountToId) {
        this.accountToId = accountToId;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public int getAccountFromId() {
        return accountFromId;
    }

    public int getAccountToId() {
        return accountToId;
    }

    public int getPayload() {
        return payload;
    }
}

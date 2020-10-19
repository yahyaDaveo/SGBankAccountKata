package com.bank.account.model;

import com.bank.account.type.Amount;

import java.time.LocalDate;

public class Deposit extends Operation {

    public Deposit(LocalDate date, Amount amount, Amount currentBalance) {
        super(date, amount, currentBalance);
    }

    @Override
    void calculateNewBalance(Amount currentBalance) {
        balance = currentBalance.addAmount(amount);
    }
}

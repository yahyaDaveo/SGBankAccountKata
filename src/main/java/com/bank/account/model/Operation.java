package com.bank.account.model;

import com.bank.account.type.Amount;

import java.time.LocalDate;

public abstract class Operation {

    private LocalDate date;
    Amount amount;
    Amount balance;

    Operation(LocalDate date, Amount amount, Amount currentBalance) {
        this.date = date;
        this.amount = amount;
        calculateNewBalance(currentBalance);
    }

    abstract void calculateNewBalance(Amount oldBalance);

}

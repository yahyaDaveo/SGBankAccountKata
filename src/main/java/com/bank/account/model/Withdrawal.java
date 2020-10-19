package com.bank.account.model;

import com.bank.account.type.Amount;

import java.time.LocalDate;

public class Withdrawal extends Operation {

    public Withdrawal(LocalDate date, Amount amount, Amount currentBalance) {
        super(date, amount, currentBalance);
    }

    @Override
    void calculateNewBalance(Amount oldBalance) {
        balance = oldBalance.subtractAmount(amount);
    }

    @Override
    void appendOperation(StringBuilder stringBuilder) {
        stringBuilder.append("WITHDRAWAL");
    }
}

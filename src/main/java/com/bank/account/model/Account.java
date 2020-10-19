package com.bank.account.model;

import com.bank.account.type.Amount;

import java.time.LocalDate;

public class Account {

    private AccountStatement statement;

    private Amount balance;

    public Account(AccountStatement statement) {
        this.statement = statement;
        balance= new Amount(0);
    }

    public void depositMoney(LocalDate depositDate, Amount amount) {
        Operation deposit = new Deposit(depositDate, amount, balance);
        balance = deposit.balance;
        statement.addOperation(deposit);
    }

    public Amount getBalance() {
        return balance;
    }
}

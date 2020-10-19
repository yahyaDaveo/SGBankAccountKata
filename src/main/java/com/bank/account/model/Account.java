package com.bank.account.model;

import com.bank.account.printer.Writer;
import com.bank.account.type.Amount;

import java.time.LocalDate;

public class Account {

    private static final String HEADER_TO_PRINT = "Operation | Date     | Amount | Balance ";
    private AccountStatement statement;
    private Amount balance;

    public Account(AccountStatement statement) {
        this.statement = statement;
        balance = new Amount(0);
    }

    public void depositMoney(LocalDate depositDate, Amount amount) {
        Operation deposit = new Deposit(depositDate, amount, balance);
        balance = deposit.balance;
        statement.addOperation(deposit);
    }

    public void withdrawalMoney(LocalDate withdrawalDate, Amount amount) {
        Operation withdrawal = new Withdrawal(withdrawalDate, amount, balance);
        balance = withdrawal.balance;
        statement.addOperation(withdrawal);
    }

    public void printStatement(Writer writer) {
        writer.print(HEADER_TO_PRINT);
        writer.print("---------------------------------------");
        statement.printOperations(writer);
    }

    public Amount getBalance() {
        return balance;
    }
}

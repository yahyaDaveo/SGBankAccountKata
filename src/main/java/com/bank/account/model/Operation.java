package com.bank.account.model;

import com.bank.account.builder.DateBuilder;
import com.bank.account.printer.Writer;
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

    public void printOperation(Writer writer) {
        StringBuilder stringBuilder = new StringBuilder();
        appendOperation(stringBuilder);
        appendDate(stringBuilder);
        appendAmount(stringBuilder);
        appendBalance(stringBuilder);
        writer.print(stringBuilder.toString());
    }

    abstract void appendOperation(StringBuilder stringBuilder);

    private void appendDate(StringBuilder stringBuilder) {
        stringBuilder.append(" | ")
                .append(DateBuilder.format(date));
    }

    private void appendAmount(StringBuilder stringBuilder) {
        stringBuilder.append(" | ")
                .append(amount.toPrint());
    }

    private void appendBalance(StringBuilder stringBuilder) {
        stringBuilder.append(" | ")
                .append(balance.toPrint());
    }
}

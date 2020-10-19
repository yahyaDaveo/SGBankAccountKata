package com.bank.account;

import com.bank.account.model.Account;
import com.bank.account.model.AccountStatement;
import com.bank.account.printer.impl.ConsoleWriter;
import com.bank.account.type.Amount;

import static com.bank.account.builder.DateBuilder.dateFrom;

public class MainApp {

    public static void main(String[] args) {

        Account myAccount = new Account(new AccountStatement());

        myAccount.depositMoney(dateFrom("12/07/2020"), Amount.from(500));
        myAccount.withdrawalMoney(dateFrom("01/10/2020"), Amount.from(200));
        myAccount.depositMoney(dateFrom("29/10/2020"), Amount.from(700));

        myAccount.printStatement(new ConsoleWriter());
    }
}

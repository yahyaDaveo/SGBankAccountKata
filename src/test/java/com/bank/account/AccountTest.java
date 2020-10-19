package com.bank.account;


import com.bank.account.builder.DateBuilder;
import com.bank.account.model.Account;
import com.bank.account.model.AccountStatement;
import com.bank.account.model.Deposit;
import com.bank.account.printer.impl.ConsoleWriter;
import com.bank.account.type.Amount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    private AccountStatement statement;
    @Mock
    private ConsoleWriter writer;
    private Account account;

    @Before
    public void before() {
        account = new Account(statement);
    }

    @Test
    public void testDepositMoney() {
        LocalDate depositDate = DateBuilder.dateFrom("10/10/2020");
        Amount depositAmount = Amount.from(1000);

        account.depositMoney(depositDate, depositAmount);
        verify(statement).addOperation(any(Deposit.class));
        assertEquals(account.getBalance(), depositAmount);
    }

    @Test
    public void testWithdrawalMoney() {
        LocalDate withdrawalDate = DateBuilder.dateFrom("10/10/2020");
        Amount withdrawalAmount = Amount.from(1000);

        account.withdrawalMoney(withdrawalDate, withdrawalAmount);
        verify(statement).addOperation(any(Deposit.class));
        assertEquals(account.getBalance(), withdrawalAmount.negative());
    }

    @Test
    public void testPrintStatement() {

        account.printStatement(writer);
        verify(statement).printOperations(writer);
        verify(writer).print("Operation | Date     | Amount | Balance ");
        verify(writer).print("---------------------------------------");
    }
}

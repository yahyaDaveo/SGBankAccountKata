package com.bank.account;

import com.bank.account.model.Withdrawal;
import com.bank.account.printer.impl.ConsoleWriter;
import com.bank.account.type.Amount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.bank.account.builder.DateBuilder.dateFrom;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WithdrawalTest {

    @Mock
    private Amount currentBalance;
    @Mock
    private ConsoleWriter writer;

    @Test
    public void verifyAmountSubtractedFromBalance() {

        Amount amountToWithdrawal = Amount.from(100);
        new Withdrawal(dateFrom("10/10/2020"), amountToWithdrawal, currentBalance);

        verify(currentBalance).subtractAmount(amountToWithdrawal);
    }

    @Test
    public void verifyPrintOperation() {

        Amount balance = Amount.from(200);
        Amount amountToDeposit = Amount.from(100);
        Withdrawal deposit = new Withdrawal(dateFrom("10/10/2020"), amountToDeposit, balance);

        deposit.printOperation(writer);
        verify(writer).print("WITHDRAWAL | 10/10/2020 | 100 | 100");
    }
}

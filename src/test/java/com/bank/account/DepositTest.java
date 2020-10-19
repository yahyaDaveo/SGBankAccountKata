package com.bank.account;

import com.bank.account.builder.DateBuilder;
import com.bank.account.model.Deposit;
import com.bank.account.type.Amount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DepositTest {

    @Mock
    private Amount currentBalance;

    @Test
    public void testDepositVerifyAmountAddedToBalance() {

        Amount amountToDeposit = Amount.from(100);
        new Deposit(DateBuilder.dateFrom("10/10/2020"), amountToDeposit, currentBalance);
        verify(currentBalance).addAmount(amountToDeposit);
    }

}

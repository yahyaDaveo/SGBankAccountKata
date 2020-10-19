package com.bank.account;

import com.bank.account.builder.DateBuilder;
import com.bank.account.model.Withdrawal;
import com.bank.account.type.Amount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WithdrawalTest {

    @Mock
    private Amount currentBalance;

    @Test
    public void testWithdrawalVerifyAmountSubtractedFromBalance() {

        Amount amountToWithdrawal = Amount.from(100);
        new Withdrawal(DateBuilder.dateFrom("10/10/2020"), amountToWithdrawal, currentBalance);
        verify(currentBalance).subtractAmount(amountToWithdrawal);
    }
}
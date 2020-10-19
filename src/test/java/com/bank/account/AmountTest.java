package com.bank.account;

import com.bank.account.type.Amount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AmountTest {

    @Test
    public void testTwoAmountsSameValue() {
        Amount six = new Amount(6);
        assertEquals(six, Amount.from(6));
    }

    @Test
    public void testTwoAmountsDifferentValue() {
        Amount six = new Amount(6);
        Amount five = new Amount(5);
        assertThat(six, not(five));
    }

    @Test
    public void testAmountFromInt() {
        Amount six = new Amount(6);
        Amount fromSix = Amount.from(6);
        assertEquals(six, fromSix);
    }

    @Test
    public void testAddAmount() {
        Amount six = new Amount(6);
        Amount four = new Amount(4);
        Amount ten= new Amount(10);
        assertEquals(six.addAmount(four), ten);
    }

}

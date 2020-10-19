package com.bank.account.type;

public class Amount {

    private int value;

    public Amount(int value) {
        this.value = value;
    }

    public static Amount from(int amount) {
        return new Amount(amount);
    }

    public Amount addAmount(Amount amount) {
        return new Amount(value + amount.value);
    }

    public Amount subtractAmount(Amount amount) {
        return new Amount(value - amount.value);
    }

    public Amount negative() {
        return from(-value);
    }

    public String toPrint() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        Amount amount = (Amount) obj;
        return value == amount.value;
    }
}

package com.bank.account.printer.impl;

import com.bank.account.printer.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void print(String s) {
        System.out.println(s);
    }
}

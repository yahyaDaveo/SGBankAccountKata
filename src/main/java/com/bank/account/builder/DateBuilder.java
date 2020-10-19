package com.bank.account.builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateBuilder {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate dateFrom(String date) {
        return LocalDate.parse(date, formatter);
    }

    public static String format(LocalDate date) {
        return formatter.format(date);
    }
}

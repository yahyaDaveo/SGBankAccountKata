package com.bank.account.model;

import com.bank.account.printer.Writer;

import java.util.ArrayList;
import java.util.List;

public class AccountStatement {

    private List<Operation> operations = new ArrayList<>();

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public void printOperations(Writer writer) {
        for (Operation operation : operations) {
            operation.printOperation(writer);
        }
    }
}

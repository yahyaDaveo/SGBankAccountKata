package com.bank.account.model;

import java.util.ArrayList;
import java.util.List;

public class AccountStatement {

    private List<Operation> operations = new ArrayList<>();

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

}

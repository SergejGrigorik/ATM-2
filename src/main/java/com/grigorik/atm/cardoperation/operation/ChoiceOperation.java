package com.grigorik.atm.cardoperation.operation;

import com.grigorik.atm.cardoperation.operation.interfaces.Operation;

public class ChoiceOperation {
    private Operation operation;

    public ChoiceOperation(Operation operation) {
        this.operation = operation;
    }


    public void operation(String number) {
        operation.execute(number);
    }
}

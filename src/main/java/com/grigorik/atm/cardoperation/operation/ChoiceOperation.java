package com.grigorik.atm.cardoperation.operation;

import com.grigorik.atm.cardoperation.operation.interfaces.OperationInterf;

public class ChoiceOperation {
    private OperationInterf operationInterf;

    public ChoiceOperation(OperationInterf operationInterf) {
        this.operationInterf = operationInterf;
    }


    public void operation(String number) {
        operationInterf.execute(number);
    }
}

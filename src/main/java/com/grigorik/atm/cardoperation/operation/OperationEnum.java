package com.grigorik.atm.cardoperation.operation;

import com.grigorik.atm.cardoperation.operation.interfaces.OperationInterf;

public enum OperationEnum {
    SHOW(1,ShowBalanceOperation.getInstance()),PUT(2,PutMoneyOperation.getInstance()),
    WITHDRAWAL(3,WithdrawalOperation.getInstance()),EXIT(4,Exit.getInstance()),
    DEFAULT(5,Default.getInstance());

    private int value;
    public OperationInterf operationInterf;

    OperationEnum(int value, OperationInterf operationInterf) {
        this.value = value;
        this.operationInterf = operationInterf;
    }

    public int getValue() {
        return value;
    }
    public OperationInterf getOperation() {
        return operationInterf;
    }

}

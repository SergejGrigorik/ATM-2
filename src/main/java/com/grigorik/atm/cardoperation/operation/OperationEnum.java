package com.grigorik.atm.cardoperation.operation;
import com.grigorik.atm.cardoperation.operation.interfaces.Operation;

public enum OperationEnum {
    SHOW(1,ShowBalanceOperation.getInstance()),
    PUT(2,PutMoneyOperation.getInstance()),
    WITHDRAWAL(3,WithdrawalOperation.getInstance()),
    EXIT(4,Exit.getInstance()),
    DEFAULT(5,Default.getInstance());

    private int value;
    public Operation operation;

    OperationEnum(int value, Operation operation) {
        this.value = value;
        this.operation = operation;
    }

    public int getValue() {
        return value;
    }
    public Operation getOperation() {
        return operation;
    }

}

package com.grigorik.atm.cardoperation.operation;

import com.grigorik.atm.cardoperation.operation.interfaces.OperationInterf;

public class Default implements OperationInterf {
    private static Default Default;
    public static Default getInstance() {
        if (Default == null) {
            Default = new Default();
        }

        return Default;
    }
    @Override
    public void execute(String number) {

    }
}

package com.grigorik.atm.cardoperation.operation;

import com.grigorik.atm.cardoperation.operation.interfaces.Operation;

public class Default implements Operation {
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

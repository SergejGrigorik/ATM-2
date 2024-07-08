package com.grigorik.atm.cardoperation.operation;

import com.grigorik.atm.cardoperation.operation.interfaces.Operation;
import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.entity.card.CardUnfo;

public class ShowBalanceOperation extends AbstractMenu implements Operation {
    private final Bank bank = Bank.getInstance();
    private static ShowBalanceOperation showBalanceOperation;


    private ShowBalanceOperation() {
    }

    public static ShowBalanceOperation getInstance() {
        if (showBalanceOperation == null) {
            showBalanceOperation = new ShowBalanceOperation();
        }
        return showBalanceOperation;
    }

    public void viewBalance(String number) {
        CardUnfo cardUnfo = bank.getCards().get(number);
        System.out.println("\nВаш баланс составляет - " + cardUnfo.getSum());
    }

    @Override
    public void execute(String number) {
        viewBalance(number);
        nextOrExit();
    }
}

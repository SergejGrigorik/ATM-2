package com.grigorik.atm.cardoperation;

import com.grigorik.atm.bank.Bank;
import com.grigorik.atm.cardEntity.CardUnfo;

import java.util.HashMap;

public class ShowBalanceOperation {
    private Bank bank = Bank.getInstance();
    private HashMap<String, CardUnfo> cards;
    private static ShowBalanceOperation showBalanceOperation;
    private CardUnfo cardUnfo;

    private ShowBalanceOperation() {
    }

    public static ShowBalanceOperation getInstance() {
        if (showBalanceOperation == null) {
            showBalanceOperation = new ShowBalanceOperation();
        }
        return showBalanceOperation;
    }

    public void viewBalance(String number) {
        bank = Bank.getInstance();
        cardUnfo = bank.getCards().get(number);
        System.out.println("\nВаш баланс составляет - " + cardUnfo.getSum());
    }

}

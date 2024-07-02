package com.grigorik.atm.cardoperation;

import com.grigorik.atm.bank.Bank;
import com.grigorik.atm.cardEntity.CardUnfo;
import com.grigorik.atm.chekcorrectinputsum.ParseInputSum;
import com.grigorik.atm.writefile.WriteDataBase;

import java.util.Scanner;

public class PutMoneyOperation {
    private CardUnfo cardUnfo;
    private static PutMoneyOperation instance;
    private Scanner scanner = new Scanner(System.in);
    private String regex = "[0-9]+|[0-9]+\\.[0-9]+|[0-9]+,[0-9]+";
    private Bank bank = Bank.getInstance();
    private double limit = 1000000;
    private ParseInputSum parseInputSum;

    private PutMoneyOperation() {

    }

    public static PutMoneyOperation getInstance() {
        if (instance == null) {
            instance = new PutMoneyOperation();
        }
        return instance;
    }

    public void addMoneyDeposit(String number) {
        cardUnfo = bank.cardUnfo(number);
        System.out.println("\nВведите сумму ");
        String sum = scanner.nextLine();
        if (checkCorrectInput(sum)) {
            return;
        }
        Double parseSum = parseInputSum.getInstance().getParseSum(sum);
        parseSum = parseSum + cardUnfo.getSum();
        if (parseSum < limit) {
            cardUnfo.setSum(parseSum);
            System.out.println("Деньги успешно зачислены");
        } else {
            System.out.println("Операция не может быть завершена , поскульку сумма на счету не может превышать - " + limit);
            return;
        }
    }

    private boolean checkCorrectInput(String sum) {
        if (!sum.matches(regex)) {
            System.out.println("ввод должнен содержать только числа");
            return true;
        }
        return false;
    }

}

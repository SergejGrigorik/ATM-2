package com.grigorik.atm.cardoperation;

import com.grigorik.atm.bank.Bank;
import com.grigorik.atm.chekcorrectinputsum.CheckSum;
import com.grigorik.atm.entity.CardUnfo;
import com.grigorik.atm.parse.ParseInputSum;

import java.util.Scanner;

public class PutMoneyOperation {
    private CardUnfo cardUnfo;
    private static PutMoneyOperation instance;
    private Scanner scanner = new Scanner(System.in);
    private String regex = "[0-9]+|[0-9]+\\.[0-9]+|[0-9]+,[0-9]+";
    private Bank bank = Bank.getInstance();
    private double limit = 1000000;
    private ParseInputSum parseInputSum;
    private CheckSum checkSum = CheckSum.getInstance();

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
        if (checkSum.isCorrectInput(sum)) {
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



}

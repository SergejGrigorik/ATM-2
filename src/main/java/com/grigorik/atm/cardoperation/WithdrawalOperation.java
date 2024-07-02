package com.grigorik.atm.cardoperation;

import com.grigorik.atm.bank.Bank;
import com.grigorik.atm.cardEntity.CardUnfo;
import com.grigorik.atm.chekcorrectinputsum.ParseInputSum;

import java.util.Scanner;

public class WithdrawalOperation {
    private static WithdrawalOperation withdrawalOperation;
    private Bank bank = Bank.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private String regex = "[0-9]+|[0-9]+\\.[0-9]+|[0-9]+,[0-9]+";
    private CardUnfo cardUnfo;
    private ParseInputSum parseInputSum;

    private WithdrawalOperation() {
    }

    public static WithdrawalOperation getInstance() {
        if (withdrawalOperation == null) {
            withdrawalOperation = new WithdrawalOperation();
        }
        return withdrawalOperation;
    }

    public void withdrawalCash(String number){
        cardUnfo = bank.cardUnfo(number);
        System.out.println("Введите сумму");
        String stringSum = scanner.nextLine();
        if(checkCorrectInput(stringSum)){
            return;
        }
        Double parseSum = parseInputSum.getInstance().getParseSum(stringSum);
        if (checkSum(parseSum)){
            cardUnfo.setSum(cardUnfo.getSum() - parseSum);
        }else {
            System.out.println("У Вас недостаточно средств\nВаш баланс " + cardUnfo.getSum());
        }

    }
    private boolean checkSum(Double sum){
        if(cardUnfo.getSum() < sum) {
            return false;
        }
        return true;
    }
    private boolean checkCorrectInput(String sum) {
        if (!sum.matches(regex)) {
            System.out.println("ввод должнен содержать только числа");
            return true;
        }
        return false;
    }

}

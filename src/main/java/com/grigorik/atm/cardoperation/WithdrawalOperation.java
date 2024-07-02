package com.grigorik.atm.cardoperation;

import com.grigorik.atm.bank.Bank;
import com.grigorik.atm.chekcorrectinputsum.CorrectInputSum;
import com.grigorik.atm.entity.CardUnfo;
import com.grigorik.atm.parse.ParseInputSum;

import java.util.Scanner;

public class WithdrawalOperation {
    private static WithdrawalOperation withdrawalOperation;
    private Bank bank = Bank.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private CardUnfo cardUnfo;
    private ParseInputSum parseInputSum;
    private CorrectInputSum correctInputSum = CorrectInputSum.getInstance();

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
        System.out.println("\nВведите сумму");
        String stringSum = scanner.nextLine();
        if(correctInputSum.isCorrectInput(stringSum)){
            return;
        }
        Double parseSum = parseInputSum.getInstance().getParseSum(stringSum);
        if (checkSum(parseSum)){

            cardUnfo.setSum(cardUnfo.getSum() - parseSum);
            System.out.println("Вы успешно сняли деньги");
        }else {
            System.out.println("У Вас недостаточно средств\nВаш баланс составляет - " + cardUnfo.getSum());
        }

    }
    private boolean checkSum(Double sum){
        if(cardUnfo.getSum() < sum) {
            return false;
        }
        return true;
    }


}

package com.grigorik.atm.cardoperation.operation;

import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.utility.chekcorrectinputsum.ValidationInputSum;
import com.grigorik.atm.entity.card.CardUnfo;
import com.grigorik.atm.utility.parse.ParseInputSum;

import java.math.BigDecimal;
import java.util.Scanner;

public class WithdrawalOperation {
    private static WithdrawalOperation withdrawalOperation;
    private final Bank bank = Bank.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private CardUnfo cardUnfo;
    private final ValidationInputSum validationInputSum = ValidationInputSum.getInstance();

    private WithdrawalOperation() {
    }

    public static WithdrawalOperation getInstance() {
        if (withdrawalOperation == null) {
            withdrawalOperation = new WithdrawalOperation();
        }
        return withdrawalOperation;
    }

    public void withdrawalCash(String number){
        cardUnfo = bank.getCardUnfo(number);
        System.out.println("\nВведите сумму");
        String stringSum = scanner.nextLine();
        if(validationInputSum.isCorrectInput(stringSum)){
            return;
        }
        BigDecimal parseSum = ParseInputSum.getInstance().getParseSum(stringSum);
        if (checkSumCard(parseSum) && checkBakanceBank()){
            cardUnfo.setSum(cardUnfo.getSum().subtract(parseSum));
            bank.setBalance(bank.getBalance().subtract(parseSum));
            System.out.println("Вы успешно сняли деньги");
        }else {
            System.out.println("У Вас недостаточно средств\nВаш баланс составляет - " + cardUnfo.getSum());
        }

    }

    private boolean checkBakanceBank() {
        return  cardUnfo.getSum().compareTo(bank.getBalance()) <= 0;
    }

    private boolean checkSumCard(BigDecimal sum){

        return cardUnfo.getSum().compareTo(sum) >= 0 ;
    }




}

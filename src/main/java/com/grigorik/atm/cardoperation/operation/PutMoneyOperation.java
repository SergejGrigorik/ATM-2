package com.grigorik.atm.cardoperation.operation;

import com.grigorik.atm.cardoperation.operation.interfaces.OperationInterf;
import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.utility.chekcorrectinputsum.ValidationInputSum;
import com.grigorik.atm.entity.card.CardUnfo;
import com.grigorik.atm.utility.parse.ParseInputSum;

import java.math.BigDecimal;
import java.util.Scanner;

public class PutMoneyOperation implements OperationInterf {
    private static PutMoneyOperation instance;
    private final Scanner scanner = new Scanner(System.in);
    private final Bank bank = Bank.getInstance();
    private final ValidationInputSum validationInputSum = ValidationInputSum.getInstance();
    private final BigDecimal limit = new BigDecimal("1000000");


    private PutMoneyOperation() {

    }

    public static PutMoneyOperation getInstance() {
        if (instance == null) {
            instance = new PutMoneyOperation();
        }
        return instance;
    }

    public void addMoneyDeposit(String number) {
        CardUnfo cardUnfo = bank.getCardUnfo(number);
        System.out.println("\nВведите сумму ");
        String sum = scanner.nextLine();
        if (validationInputSum.isCorrectInput(sum)) {
            return;
        }
        BigDecimal correctInputSum = ParseInputSum.getInstance().getParseSum(sum);
        BigDecimal newBalanceCard  = correctInputSum.add(cardUnfo.getSum());

        if (correctInputSum.compareTo(limit) <= 0) {
            cardUnfo.setSum(newBalanceCard);
            bank.setBalance(bank.getBalance().add(correctInputSum));
            System.out.println("Деньги успешно зачислены");
        } else {
            System.out.println("Операция не может быть завершена , поскольку сумма на счету не может превышать - " + limit);
            return;
        }
    }


    @Override
    public void execute(String number) {
        addMoneyDeposit(number);
    }
}

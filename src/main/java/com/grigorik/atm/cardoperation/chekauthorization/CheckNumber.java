package com.grigorik.atm.cardoperation.chekauthorization;

import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.entity.card.CardUnfo;
import com.grigorik.atm.cardoperation.operation.Exit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckNumber {
    private static CheckNumber checkNumber;
    private final Bank bank = Bank.getInstance();
    private final String regex = "[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}";
    private final String unlocked = "unlocked";
    private final Exit exit = Exit.getInstance();
    private CardUnfo cardUnfo;


    private CheckNumber() {

    }

    public static CheckNumber getInstance() {
        if (checkNumber == null) {
            checkNumber = new CheckNumber();
        }
        return checkNumber;

    }

    public boolean isValidateNumber(String numberInput) {
        if (!correctNumber(numberInput)) {
            System.out.println("номер введен некорректно , номер не соответствует формату : ХХХХ-ХХХХ-ХХХХ-ХХХХ ");
            return false;
        }
        if (!containsCardInBank(numberInput)) {
            System.out.println("такого номера не существует");
            return false;
        }
        if (isBlock(numberInput)) {
            System.out.println("Ваша карта заблокирована до " + cardUnfo.getDateBlock());
            exit.exitAtm();
        }
        return true;


    }

    private boolean correctNumber(String numberInput) {
        if (numberInput.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean containsCardInBank(String numberInput) {
        for (String numberCard : bank.getCards().keySet()) {
            if (numberCard.equals(numberInput)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBlock(String numberInput) {
        cardUnfo = bank.getCards().get(numberInput);
        if (cardUnfo.getBlock().equals(unlocked) || checkDateBlock()) {
            return false;
        }
        return true;
    }

    private boolean checkDateBlock() {
        if (parseDateBlockCard().isBefore(LocalDateTime.now())) {
            cardUnfo.setBlock(unlocked);
            cardUnfo.setDateBlock("-");
            return true;
        }
        return false;
    }

    private LocalDateTime parseDateBlockCard() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm");
        return LocalDateTime.parse(cardUnfo.getDateBlock(), formatter);
    }
}


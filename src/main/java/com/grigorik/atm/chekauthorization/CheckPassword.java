package com.grigorik.atm.chekauthorization;

import com.grigorik.atm.bank.Bank;
import com.grigorik.atm.entity.CardUnfo;
import com.grigorik.atm.cardoperation.Exit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckPassword {
    private static String password;
    private static CheckPassword checkPassword;
    private Bank bank = Bank.getInstance();
    private int countAttempt;
    private Exit exit = Exit.getInstance();
    private CardUnfo cardUnfo;
    private String block = "block";
    private CheckPassword() {
    }

    public static CheckPassword getInstance() {
        if (password == null) {
            checkPassword = new CheckPassword();
        }
        return checkPassword;
    }


    public boolean isValidatePassword(String passwordInput) {

        if (comparePasswordInputAndBank(passwordInput)) {
            countAttempt = 0;
            cardUnfo.setCountInputPassword(countAttempt);
            return true;

        }else if (countAttempt == 1) {
            System.out.println("Неверно введен пароль , осталось " + 2 + " попытки!");
            return false;
        } else if ( countAttempt==2 ) {
            System.out.println("\nНеверно введен пароль , осталась " + 1 + " попытка!\nПри введении неверного пароля Ваша карта будет заблокирована на сутки ");
            return false;
        }
        blockCard();
        return false;
    }

    public void countInputPassword(String numberInput){
         cardUnfo = bank.getCards().get(numberInput);
         countAttempt = cardUnfo.getCountInputPassword();
        if (countAttempt == 0){
            return;
        }else if (countAttempt == 2){
            System.out.println("У вас осталась одна попытка ввести пароль , при введении неверного пароля Ваша карта будет заблокирована на сутки");
        }else if (countAttempt ==1){
            System.out.println("У вас осталось две попытки ввести пароль ");
        }

    }


    private boolean comparePasswordInputAndBank(String passwordInput) {

        if (cardUnfo.getPassword().equals(passwordInput)) {
            return true;
        }
        countAttempt++;
        cardUnfo.setCountInputPassword(countAttempt);
        return false;
    }



    private void blockCard(){
        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime dateTimeBlock = dateTimeNow.plusDays(1);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm");
        String datePasswordBlock = dateFormat.format(dateTimeBlock);
        System.out.println("Вы ввели 3 раза неправильный пароль , карта будет заблокирована до " + datePasswordBlock);
        cardUnfo.setBlock(block);
        cardUnfo.setDateBlock(datePasswordBlock);
        cardUnfo.setCountInputPassword(0);
        exit.exitAtm();
    }
}

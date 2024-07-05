package com.grigorik.atm.menu;

import com.grigorik.atm.cardoperation.operation.Exit;
import com.grigorik.atm.cardoperation.operation.PutMoneyOperation;
import com.grigorik.atm.cardoperation.operation.ShowBalanceOperation;
import com.grigorik.atm.cardoperation.operation.WithdrawalOperation;
import com.grigorik.atm.cardoperation.chekauthorization.CheckNumber;
import com.grigorik.atm.cardoperation.chekauthorization.CheckPassword;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final CheckNumber checkNumber = CheckNumber.getInstance();
    private final CheckPassword checkPassword = CheckPassword.getInstance();
    private String number;
    private String password;
    private final ShowBalanceOperation showBalanceOperation = ShowBalanceOperation.getInstance();
    private final Exit exit = Exit.getInstance();
    private final PutMoneyOperation putMoneyOperation = PutMoneyOperation.getInstance();
    private final WithdrawalOperation withdrawalOperation = WithdrawalOperation.getInstance();
    private final String nonCorrectInput = "Некорректный ввод , выберете операцию из списка";


    public void inputNumber() {
        System.out.println("\nВведите номер карточки согласно формату : ХХХХ-ХХХХ-ХХХХ-ХХХХ):\t");
        chekInputNumber();
    }

    public void chekInputNumber() {
        number = scanner.nextLine();
        if (checkNumber.isValidateNumber(number)) {
            System.out.println("\nНомер введен успешно!");
            checkPassword.countInputPassword(number);
            inputPassword();
        } else {
            operationIfInvalidNumber();
        }
    }

    private void operationIfInvalidNumber() {
        System.out.println("""
                
                Выберете номер операции
                1.Ввести номер еще раз
                2.Выход""");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                inputNumber();
                break;
            case "2":
                exit.exitAtm();
                break;
            default:
                System.out.println(nonCorrectInput);
                operationIfInvalidNumber();
                break;
        }
    }

    public void inputPassword() {
        System.out.println("\nВведите пароль");
        password = scanner.nextLine();
        if (checkPassword.isValidatePassword(password)) {
            System.out.println("\nПароль введен успешно");
            choice();
        } else {
            operationIfInvalidPassword();
        }
    }

    private void operationIfInvalidPassword() {
        System.out.println("""
                               
                Выберете номер операции:
                                
                1.Ввести пароль еще раз
                2.Выход""");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                inputPassword();
                break;
            case "2":
                exit.exitAtm();
                break;
            default:
                System.out.println(nonCorrectInput);
                operationIfInvalidPassword();
                break;
        }
    }


    public void choice() {
        System.out.println("""
                                
                Выберете номер операции:
                1.Посмотреть баланс
                2.Положить деньги на карту
                3.Снять дженьги
                4.Выход
                """);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                showBalanceOperation.viewBalance(number);
                nextOrExit();
                break;
            case "2":
                nextPutOrBack();
                nextOrExit();
                break;
            case "3":
                nextWithdrawalOrBack();
                nextOrExit();
                break;
            case "4":
                exit.exitAtm();
                break;
            default:
                System.out.println(nonCorrectInput);
                choice();
                break;
        }


    }

    private void nextPutOrBack() {
        System.out.println("""
                
                1.Вернуться в меню
                2.Ввести сумму
                """);
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                choice();
                break;
            case "2":
                putMoneyOperation.addMoneyDeposit(number);
                break;
            default:
                System.out.println(nonCorrectInput);
                nextPutOrBack();
                break;

        }

    }

    private void nextWithdrawalOrBack() {
        System.out.println("""
                
                1.Вернуться в меню
                2.Ввести сумму""");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                choice();
                break;
            case "2":
                withdrawalOperation.withdrawalCash(number);
                break;
            default:
                System.out.println(nonCorrectInput);
                nextWithdrawalOrBack();
                break;

        }

    }

    private void nextOrExit() {
        System.out.println("""
                
                1.Продолжить
                2.Выход""");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                choice();
                break;
            case "2":
                exit.exitAtm();
                break;
            default:
                System.out.println(nonCorrectInput);
                nextOrExit();
                break;

        }
    }
}

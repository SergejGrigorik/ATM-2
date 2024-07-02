package com.grigorik.atm.menu;

import com.grigorik.atm.cardoperation.Exit;
import com.grigorik.atm.cardoperation.PutMoneyOperation;
import com.grigorik.atm.cardoperation.ShowBalanceOperation;
import com.grigorik.atm.cardoperation.WithdrawalOperation;
import com.grigorik.atm.chekauthorization.CheckNumber;
import com.grigorik.atm.chekauthorization.CheckPassword;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private CheckNumber checkNumber = CheckNumber.getInstance();
    private CheckPassword checkPassword = CheckPassword.getInstance();
    private String number;
    private String password;
    private ShowBalanceOperation showBalanceOperation = ShowBalanceOperation.getInstance();
    private Exit exit = Exit.getInstance();
    private PutMoneyOperation putMoneyOperation = PutMoneyOperation.getInstance();
    private WithdrawalOperation withdrawalOperation = WithdrawalOperation.getInstance();
    private String nonCorrectInput = "Некорректный ввод , выберете операцию из списка";


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
        System.out.println("\nВыберете номер операции\n 1.Ввести номер еще раз\n 2.Выход\t");
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
        System.out.println("\nВведите пароль\t");
        password = scanner.nextLine();
        if (checkPassword.isValidatePassword(password)) {
            System.out.println("\nПароль введен успешно\t");
            choice();
        } else {
            operationIfInvalidPassword();
        }
    }

    private void operationIfInvalidPassword() {
        System.out.println("\nВыберете номер операции\n 1.Ввести пароль еще раз\n 2.Выход\t");
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
        System.out.println("\nВыберете номер операции \n 1.Посмотреть баланс\n 2.Положить деньги на карту\n " +
                "3.Снять дженьги\n 4.Выход ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                showBalanceOperation.viewBalance(number);
                nextOrExit();
                break;
            case "2" :
                nextPutOrBack();
                nextOrExit();
                break;
            case "3" :
                nextWithdrawalOrBack();
                nextOrExit();
                break;
            case "4" :
                exit.exitAtm();
                break;
            default:
                System.out.println(nonCorrectInput);
                choice();
                break;
        }


    }
    private void nextPutOrBack(){
        System.out.println("\n1.Вернуться в меню\n2.Ввести сумму");
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
    private void nextWithdrawalOrBack(){
        System.out.println("\n1.Вернуться в меню\n2.Ввести сумму");
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
    private void nextOrExit(){
        System.out.println("\n1.Продолжить\n2.Выход");
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

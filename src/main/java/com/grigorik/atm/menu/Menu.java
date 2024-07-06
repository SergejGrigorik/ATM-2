package com.grigorik.atm.menu;

import com.grigorik.atm.cardoperation.operation.*;
import com.grigorik.atm.cardoperation.chekauthorization.CheckNumber;
import com.grigorik.atm.cardoperation.chekauthorization.CheckPassword;
import com.grigorik.atm.cardoperation.operation.interfaces.OperationInterf;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final CheckNumber checkNumber = CheckNumber.getInstance();
    private final CheckPassword checkPassword = CheckPassword.getInstance();
    private String number;
    private String password;
    private final OperationInterf showBalanceOperation = ShowBalanceOperation.getInstance();
    private final OperationInterf exit = Exit.getInstance();
    private final OperationInterf putMoneyOperation = PutMoneyOperation.getInstance();
    private final OperationInterf withdrawalOperation = WithdrawalOperation.getInstance();
    private final String nonCorrectInput = "Некорректный ввод , выберете операцию из списка";
    private  ChoiceOperation choiceOperation ;


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
                exit.execute(number);
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
                exit.execute(number);
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
        OperationEnum operationEnum  = OperationEnum.DEFAULT;
        for (OperationEnum operation : OperationEnum.values()) {
            if(!choice.matches("[0-9]+")){
                operationEnum = OperationEnum.DEFAULT;
            }else if (operation.getValue() == parseInt(choice)) {
                operationEnum = operation;
            }
        }
        choiceOperation  = new ChoiceOperation(operationEnum.getOperation());
        switch (operationEnum) {
            case SHOW:
                choiceOperation.operation(number);
                nextOrExit();
                break;
            case PUT:
                nextPutOrBack();
                choiceOperation.operation(number);
                nextOrExit();
                break;
            case WITHDRAWAL:
                nextWithdrawalOrBack();
                choiceOperation.operation(number);
                nextOrExit();
                break;
            case EXIT:
                choiceOperation.operation(number);
                break;
            case DEFAULT:
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
//                putMoneyOperation.execute(number);
                return;
//                break;
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
                return;
//                withdrawalOperation.execute(number);
//                break;
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
                exit.execute(number);
                break;
            default:
                System.out.println(nonCorrectInput);
                nextOrExit();
                break;

        }
    }
}

package com.grigorik.atm.menu;

import com.grigorik.atm.cardoperation.operation.*;
import com.grigorik.atm.cardoperation.chekauthorization.CheckNumber;
import com.grigorik.atm.cardoperation.chekauthorization.CheckPassword;
import com.grigorik.atm.cardoperation.operation.interfaces.AbstractMenu;
import com.grigorik.atm.cardoperation.operation.interfaces.Operation;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final CheckNumber checkNumber = CheckNumber.getInstance();
    private final CheckPassword checkPassword = CheckPassword.getInstance();
    private String number;
    private String password;
    private final Operation exit = Exit.getInstance();
    private final String nonCorrectInput = "Некорректный ввод , выберете операцию из списка";
    private Map<Integer,OperationEnum> choice20peration = Arrays.stream(OperationEnum.values())
            .collect(Collectors.toMap(OperationEnum::getValue, Function.identity()));
    private AbstractMenu abstractMenu = AbstractMenu.getAbstractMenu();


    public void inputNumber() {
        abstractMenu.setMenu(this);
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
        OperationEnum operationEnum = choice20peration.getOrDefault(Integer.parseInt(choice), OperationEnum.DEFAULT);
        operationEnum.getOperation().execute(number);
        choice();
    }

}

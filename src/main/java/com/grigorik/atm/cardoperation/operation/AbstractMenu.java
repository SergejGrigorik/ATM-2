package com.grigorik.atm.cardoperation.operation;
import com.grigorik.atm.cardoperation.operation.interfaces.Operation;
import com.grigorik.atm.menu.Menu;
import java.util.Scanner;

public class AbstractMenu {
    private final String nonCorrectInput = "Некорректный ввод , выберете операцию из списка";
    private final Scanner scanner = new Scanner(System.in);
    private static  AbstractMenu abstractMenu;
    private final Operation exit = Exit.getInstance();
    private String number;

    protected AbstractMenu(){

    }
    public static AbstractMenu getAbstractMenu(){

        if(abstractMenu == null){
            abstractMenu = new AbstractMenu();

        }
        return abstractMenu;
    }


    public void nextPutOrBack() {
        System.out.println("""
                                
                1.Вернуться в меню
                2.Ввести сумму
                """);
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                Menu.getInstance().choice();
                break;
            case "2":
                return;
            default:
                System.out.println(nonCorrectInput);
                nextPutOrBack();
                break;

        }

    }

    public void nextWithdrawalOrBack() {
        System.out.println("""
                                
                1.Вернуться в меню
                2.Ввести сумму""");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                Menu.getInstance().choice();
                break;
            case "2":
                return;
            default:
                System.out.println(nonCorrectInput);
                nextWithdrawalOrBack();
                break;

        }

    }

    public void nextOrExit() {
        System.out.println("""
                                
                1.Продолжить
                2.Выход""");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                Menu.getInstance().choice();
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

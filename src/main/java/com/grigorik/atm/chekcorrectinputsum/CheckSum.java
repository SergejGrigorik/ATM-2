package com.grigorik.atm.chekcorrectinputsum;

public class CheckSum {
    private static CheckSum instance;
    private String regex = "[0-9]+|[0-9]+\\.[0-9]+|[0-9]+,[0-9]+";
    private CheckSum() {}
    public static CheckSum getInstance() {
        if (instance == null) {
            instance = new CheckSum();
        }
        return instance;
    }
    public boolean isCorrectInput(String sum) {
        if (!sum.matches(regex)) {
            System.out.println("Ввод должнен содержать только числа");
            return true;
        }
        return false;
    }
}

package com.grigorik.atm.chekcorrectinputsum;

public class CorrectInputSum {
    private static CorrectInputSum instance;
    private String regex = "[0-9]+|[0-9]+\\.[0-9]+|[0-9]+,[0-9]+";
    private CorrectInputSum() {}
    public static CorrectInputSum getInstance() {
        if (instance == null) {
            instance = new CorrectInputSum();
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

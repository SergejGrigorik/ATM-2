package com.grigorik.atm.utility.chekcorrectinputsum;

public  class ValidationInputSum {
    private static ValidationInputSum instance;
    private final String regex = "[0-9]+|[0-9]+\\.[0-9]+|[0-9]+,[0-9]+";

    private ValidationInputSum() {
    }

    public static ValidationInputSum getInstance() {
        if (instance == null) {
            instance = new ValidationInputSum();
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

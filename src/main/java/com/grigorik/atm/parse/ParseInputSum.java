package com.grigorik.atm.parse;

public class ParseInputSum {
    private  static ParseInputSum parseInputSum;
    private ParseInputSum(){}

    public static ParseInputSum getInstance() {
        if (parseInputSum == null) {
            parseInputSum = new ParseInputSum();
        }
        return parseInputSum;
    }


    public Double getParseSum(String input) {
        if (input.contains(".")) {
            Double sumDouble = Double.valueOf(input);
            return sumDouble;
        } else if (input.contains(",")) {
            String parseSum = input.replace(",", ".");
            Double sumDouble = Double.valueOf(parseSum);
            return sumDouble;
        } else {
            Double sumInt = Double.valueOf(input);
            return sumInt;
        }
    }
}

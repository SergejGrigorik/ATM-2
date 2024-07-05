package com.grigorik.atm.utility.parse;

import java.math.BigDecimal;

public class ParseInputSum {
    private  static ParseInputSum parseInputSum;
    private ParseInputSum(){}

    public static ParseInputSum getInstance() {
        if (parseInputSum == null) {
            parseInputSum = new ParseInputSum();
        }
        return parseInputSum;
    }


    public BigDecimal getParseSum(String input) {
        if (input.contains(",")) {
            String parseSum = input.replace(",", ".");
            return new BigDecimal(parseSum);
        } else {
            return new BigDecimal(input) ;
        }
    }
}

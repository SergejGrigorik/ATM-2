package com.grigorik.atm.entity.card;

import java.math.BigDecimal;

public class CardUnfo {
    private String Number;
    private String Password;
    private BigDecimal Sum;
    private String block;
    private String dateBlock;
    private Integer countInputPassword;

    public Integer getCountInputPassword() {
        return countInputPassword;
    }

    public void setCountInputPassword(Integer countInputPassword) {
        this.countInputPassword = countInputPassword;
    }

    public String getDateBlock() {
        return dateBlock;
    }

    public void setDateBlock(String dateBlock) {
        this.dateBlock = dateBlock;
    }


    public BigDecimal getSum() {
        return Sum;
    }

    public void setSum(BigDecimal sum) {
        Sum = sum;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }


    @Override
    public String toString() {

        return Number + " " + Password + " " + Sum + " " + block + " " + dateBlock + " " + countInputPassword;
    }
}


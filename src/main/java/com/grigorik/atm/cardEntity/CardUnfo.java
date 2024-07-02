package com.grigorik.atm.cardEntity;

public class CardUnfo {
    private String Number;
    private String Password;
    private double Sum;
    private String block;
    private String dateBlock;

    public String getDateBlock() {
        return dateBlock;
    }

    public void setDateBlock(String dateBlock) {
        this.dateBlock = dateBlock;
    }


    public double getSum() {
        return Sum;
    }

    public void setSum(double sum) {
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

        return Number + " " + Password + " " + Sum + " " + block + " " + dateBlock;
    }
}


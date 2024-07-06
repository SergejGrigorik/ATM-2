package com.grigorik.atm.operatetofile.readerfile;

import com.grigorik.atm.cardoperation.operation.Exit;
import com.grigorik.atm.entity.bank.Bank;

import java.io.IOException;
import java.math.BigDecimal;

public class ReadBalanceBank extends Read {
    private Bank bank = Bank.getInstance();
    private static Read readBalanceBank ;

    private ReadBalanceBank(String path) {
        super(path);
        createBalanceBank();
        Exit.getInstance().setPathBalanceBank(path);
    }
    public static Read getInstance(String path){
        if(readBalanceBank == null){
            readBalanceBank = new ReadBalanceBank(path);
        }
        return readBalanceBank;
    }


    private void createBalanceBank() {
        try {
            bank.setBalance(new BigDecimal(getScanFile().stream().findFirst().get()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

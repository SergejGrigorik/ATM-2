package com.grigorik.atm.operatetofile.readerfile;

import com.grigorik.atm.entity.bank.Bank;

import java.io.IOException;
import java.math.BigDecimal;

public class ReadBalanceBank extends Read {
    private Bank bank = Bank.getInstance();

    public ReadBalanceBank(String path){
        super(path);
        createBalanceBank();
    }


    private void createBalanceBank(){
        try {
                bank.setBalance(new BigDecimal(getScanFile().stream().findFirst().get()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

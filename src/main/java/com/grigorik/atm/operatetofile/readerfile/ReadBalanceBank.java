package com.grigorik.atm.operatetofile.readerfile;

import com.grigorik.atm.entity.bank.Bank;

import java.io.IOException;
import java.math.BigDecimal;

public class ReadBalanceBank {
    private Bank bank = Bank.getInstance();
    public static ReadBalanceBank readBalanceBank;
    private final Read read = Read.getInstance();

    private ReadBalanceBank() throws IOException {
        createBalanceBank();
    }

    public static ReadBalanceBank getInstance()  {
        if (readBalanceBank == null) {
            try {
                readBalanceBank = new ReadBalanceBank();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return readBalanceBank;
    }

    private void createBalanceBank(){
        String path = "src/main/resources/BalanceBank1";
        try {
                bank.setBalance(new BigDecimal(read.getScanFile(path).stream().findFirst().get()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

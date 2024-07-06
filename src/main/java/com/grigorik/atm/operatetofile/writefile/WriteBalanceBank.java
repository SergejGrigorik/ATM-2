package com.grigorik.atm.operatetofile.writefile;

import com.grigorik.atm.entity.bank.Bank;

import java.io.FileWriter;
import java.io.IOException;

public class WriteBalanceBank extends Write {
    private final Bank bank = Bank.getInstance();
    private static WriteBalanceBank writeBalanceBank;

    private WriteBalanceBank(String path) {
        super(path);
    }

    public static WriteBalanceBank getInstance(String path) {
        if (writeBalanceBank == null) {
            writeBalanceBank = new WriteBalanceBank(path);
        }
        return writeBalanceBank;
    }


    public void updateBalanceBank() {
        try (FileWriter writer = getFileWriter()) {
            writer.write(bank.getBalance().toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

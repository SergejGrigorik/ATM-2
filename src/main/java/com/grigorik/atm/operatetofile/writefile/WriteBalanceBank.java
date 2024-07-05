package com.grigorik.atm.operatetofile.writefile;

import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.entity.card.CardUnfo;

import java.io.FileWriter;
import java.io.IOException;

public class WriteBalanceBank {
    private final Bank bank = Bank.getInstance();
    private static WriteBalanceBank writeBalanceBank;
    private Write write = Write.getInstance();
    private String path = "src/main/resources/BalanceBank1";
    private WriteBalanceBank(){

    }
    public static WriteBalanceBank getInstance(){
        if(writeBalanceBank == null){
            writeBalanceBank = new WriteBalanceBank();
        }
        return writeBalanceBank;
    }
    public void updateDateBaseBalanceCart() {
        try (FileWriter writer = write.getFileWriter(path)) {
                writer.write(bank.getBalance().toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

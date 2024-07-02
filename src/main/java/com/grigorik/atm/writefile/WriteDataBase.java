package com.grigorik.atm.writefile;

import com.grigorik.atm.bank.Bank;
import com.grigorik.atm.entity.CardUnfo;

import java.io.FileWriter;
import java.io.IOException;


public class WriteDataBase {
    private Bank bank = Bank.getInstance();
    private static WriteDataBase writeDataBase;

    private WriteDataBase() {
    }

    public static WriteDataBase getInstance() {
        if (writeDataBase == null) {
            writeDataBase = new WriteDataBase();
        }
        return writeDataBase;
    }
    public void updateDateBase() {
        try(FileWriter writer = new FileWriter("src/main/resources/DataBaseAtmAuthorization", false))
        {
            for (CardUnfo card: bank.getCards().values()) {
                writer.write(card.toString() + '\n');
            }
            writer.flush();

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }



}

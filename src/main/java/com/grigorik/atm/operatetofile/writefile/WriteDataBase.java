package com.grigorik.atm.operatetofile.writefile;

import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.entity.card.CardUnfo;

import java.io.FileWriter;
import java.io.IOException;


public class WriteDataBase {
    private final Bank bank = Bank.getInstance();
    private static WriteDataBase writeDataBase;
    private Write write = Write.getInstance();
    private String path = "src/main/resources/DataBaseAtmAuthorization1";

    private WriteDataBase() {
    }

    public static WriteDataBase getInstance() {
        if (writeDataBase == null) {
            writeDataBase = new WriteDataBase();
        }
        return writeDataBase;
    }
    public void updateDateBaseInfoCard() {
        try (FileWriter writer = write.getFileWriter(path)) {
            for (CardUnfo card : bank.getCards().values()) {
                writer.write(card.toString() + '\n');
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

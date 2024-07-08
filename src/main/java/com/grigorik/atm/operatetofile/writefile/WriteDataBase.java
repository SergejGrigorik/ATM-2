package com.grigorik.atm.operatetofile.writefile;

import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.entity.card.CardUnfo;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataBase extends Write {
    private final Bank bank = Bank.getInstance();
    private static WriteDataBase writeDataBase;
    private String path;

    private WriteDataBase (String path) {
        super(path);
    }

    public static WriteDataBase getInstance(String path) {
        if (writeDataBase == null) {
            writeDataBase = new WriteDataBase(path);
        }
        return writeDataBase;
    }
    public void updateDateBaseInfoCard() {
        try (FileWriter writer = getFileWriter()) {
            for (CardUnfo card : bank.getCards().values()) {
                writer.write(card.toString() + '\n');
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

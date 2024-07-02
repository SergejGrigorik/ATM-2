package com.grigorik.atm.readerfile;

import com.grigorik.atm.bank.Bank;
import com.grigorik.atm.entity.CardUnfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ReaderDataBase {
    private Bank bank = Bank.getInstance();
    private CardUnfo cardUnfo;
    public static ReaderDataBase readerDataBase;

    private ReaderDataBase() throws IOException {
        creatCard();
    }

    public static ReaderDataBase getInstance() throws IOException {
        if (readerDataBase == null) {
            readerDataBase = new ReaderDataBase();
        }
        return readerDataBase;
    }

    private List<String> scanDatabase() throws IOException {
        Path path1 = Path.of("src/main/resources/DataBaseAtmAuthorization");
        List<String> strings = Files.readAllLines(path1);
        return strings;
    }


    public void creatCard() throws IOException {
        for (String string : scanDatabase()) {
            cardUnfo = new CardUnfo();
            String[] dataCard = string.split(" ");
            String numberCard = dataCard[0].trim();
            cardUnfo.setNumber(numberCard);
            cardUnfo.setPassword(dataCard[1].trim());
            cardUnfo.setSum(Double.parseDouble(dataCard[2].trim()));
            cardUnfo.setBlock(dataCard[3].trim());
            cardUnfo.setDateBlock(dataCard[4].trim());
            cardUnfo.setCountInputPassword(Integer.parseInt(dataCard[5].trim()));
            bank.setCards(numberCard, cardUnfo);

        }
    }
}


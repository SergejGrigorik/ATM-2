package com.grigorik.atm.operatetofile.readerfile;

import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.entity.card.CardUnfo;

import java.io.IOException;
import java.math.BigDecimal;


public class ReaderDataBase {
    private Bank bank = Bank.getInstance();
    public static ReaderDataBase readerDataBase;
    private final Read read = Read.getInstance();

    private ReaderDataBase() throws IOException {
        createCard();
    }

    public static ReaderDataBase getInstance(){
        if (readerDataBase == null) {
            try {
                readerDataBase = new ReaderDataBase();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return readerDataBase;
    }

    private void createCard() {
        CardUnfo cardUnfo;
        String path = "src/main/resources/DataBaseAtmAuthorization1";
        try {
            for (String string : read.getScanFile(path)) {
                cardUnfo = new CardUnfo();
                String[] dataCard = string.split(" ");
                String numberCard = dataCard[0].trim();
                cardUnfo.setNumber(numberCard);
                cardUnfo.setPassword(dataCard[1].trim());
                cardUnfo.setSum(new BigDecimal(dataCard[2].trim()));
                cardUnfo.setBlock(dataCard[3].trim());
                cardUnfo.setDateBlock(dataCard[4].trim());
                cardUnfo.setCountInputPassword(Integer.parseInt(dataCard[5].trim()));
                bank.setCards(numberCard, cardUnfo);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



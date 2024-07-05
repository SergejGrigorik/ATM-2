package com.grigorik.atm.operatetofile.readerfile;

import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.entity.card.CardUnfo;

import java.io.IOException;
import java.math.BigDecimal;


public class ReaderDataBase extends Read {
    private Bank bank = Bank.getInstance();

    public ReaderDataBase(String path) {
        super(path);
        createCard();
    }


    private void createCard() {
        CardUnfo cardUnfo;
        try {
            for (String string : getScanFile()) {
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



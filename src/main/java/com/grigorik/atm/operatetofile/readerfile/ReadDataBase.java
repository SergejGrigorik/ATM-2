package com.grigorik.atm.operatetofile.readerfile;
import com.grigorik.atm.cardoperation.operation.Exit;
import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.entity.card.CardUnfo;
import java.io.IOException;
import java.math.BigDecimal;

public class ReadDataBase extends Read {
    private Bank bank = Bank.getInstance();
    private static Read readDataBase;

    private ReadDataBase(String path) {
        super(path);
        createCard();
        Exit.getInstance().setPathDateBase(path);
    }
    public static Read getInstance(String path){
        if(readDataBase == null){
            readDataBase = new ReadDataBase(path);
        }
        return readDataBase;
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



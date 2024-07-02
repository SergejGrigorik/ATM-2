package com.grigorik.atm.bank;

import com.grigorik.atm.entity.CardUnfo;

import java.util.HashMap;

public class Bank {
    private static HashMap<String, CardUnfo> cards = new HashMap<>();
    private static Bank instance;

    private Bank() {

    }

    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public HashMap<String, CardUnfo> getCards() {
        return cards;
    }

    public void setCards(String number, CardUnfo cards) {
        this.cards.put(number, cards);
    }

    public CardUnfo cardUnfo(String number) {
        CardUnfo cardUnfo = cards.get(number);
        return cardUnfo;
    }
}

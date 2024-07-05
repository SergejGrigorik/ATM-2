package com.grigorik.atm.entity.bank;

import com.grigorik.atm.entity.card.CardUnfo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static Map<String, CardUnfo> cards = new HashMap<>();
    private static Bank instance;
    private BigDecimal balance;

    private Bank() {

    }

    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public Map<String, CardUnfo> getCards() {
        return cards;
    }

    public void setCards(String number, CardUnfo cards) {
        Bank.cards.put(number, cards);
    }

    public CardUnfo getCardUnfo(String number) {
        return cards.get(number);
    }
    public BigDecimal getAllSumBalanceCard(){
        BigDecimal sum = new BigDecimal("0");
        for (CardUnfo card : cards.values()) {
           sum = sum.add(card.getSum());
        }
        return sum;
    }

    @Override
    public String toString() {
        return balance.toString();
    }
}

package com.grigorik.atm;

import com.grigorik.atm.bank.Bank;
import com.grigorik.atm.menu.Menu;
import com.grigorik.atm.readerfile.ReaderDataBase;

import java.io.*;

public class StartAtm {
    public static void main(String[] args) throws IOException {
        ReaderDataBase readerDataBase = ReaderDataBase.getInstance();
        Bank bank = Bank.getInstance();
        System.out.println("             Здравствуйте");

        Menu menu = new Menu();
        menu.inputNumber();


    }
}

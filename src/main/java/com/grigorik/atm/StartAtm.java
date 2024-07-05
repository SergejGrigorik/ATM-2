package com.grigorik.atm;

import com.grigorik.atm.menu.Menu;
import com.grigorik.atm.operatetofile.readerfile.ReadBalanceBank;
import com.grigorik.atm.operatetofile.readerfile.ReaderDataBase;

import java.io.*;

public class StartAtm {
    public static void main(String[] args) throws IOException {
        ReadBalanceBank readBalanceBank = ReadBalanceBank.getInstance();
        ReaderDataBase readerDataBase = ReaderDataBase.getInstance();

        System.out.println("             Здравствуйте");
        Menu menu = new Menu();
        menu.inputNumber();


    }
}

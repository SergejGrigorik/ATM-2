package com.grigorik.atm;

import com.grigorik.atm.cardoperation.operation.Exit;
import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.menu.Menu;
import com.grigorik.atm.operatetofile.readerfile.ReadBalanceBank;
import com.grigorik.atm.operatetofile.readerfile.ReaderDataBase;

import java.io.*;

public class StartAtm {
    public static void main(String[] args)  {
        ReadBalanceBank readBalanceBank = new ReadBalanceBank("src/main/resources/BalanceBank1");
        ReaderDataBase readerDataBase = new ReaderDataBase( "src/main/resources/DataBaseAtmAuthorization1");
        Bank bank = Bank.getInstance();
        if(bank.getAllSumBalanceCard().compareTo(bank.getBalance()) > 0){
            System.out.println("Банк временно не работает , приносим свои извинения за доставленные неудобства");
            Exit exit = Exit.getInstance();
            exit.exitAtmError();
        }

        System.out.println("             Здравствуйте");
        Menu menu = new Menu();
        menu.inputNumber();


    }
}

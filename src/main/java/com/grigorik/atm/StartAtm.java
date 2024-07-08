package com.grigorik.atm;

import com.grigorik.atm.entity.bank.Bank;
import com.grigorik.atm.menu.Menu;
import com.grigorik.atm.operatetofile.readerfile.Read;
import com.grigorik.atm.operatetofile.readerfile.ReadBalanceBank;
import com.grigorik.atm.operatetofile.readerfile.ReadDataBase;

public class StartAtm {
    public static void main(String[] args)  {
        String dateBase = "src/main/resources/DataBaseAtmAuthorization1";
        String pathBank1 = "src/main/resources/BalanceBank1";
        Read readDataBase = ReadDataBase.getInstance(dateBase);
        Read readBalanceBank = ReadBalanceBank.getInstance(pathBank1);

        Bank bank = Bank.getInstance();
        bank.validationBalanceBank();

        System.out.println("\n             Здравствуйте");
        Menu menu = Menu.getInstance();
        menu.inputNumber();


    }
}

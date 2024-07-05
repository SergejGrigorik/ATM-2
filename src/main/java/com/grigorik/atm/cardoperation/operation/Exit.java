package com.grigorik.atm.cardoperation.operation;

import com.grigorik.atm.operatetofile.writefile.WriteBalanceBank;
import com.grigorik.atm.operatetofile.writefile.WriteDataBase;

import static java.lang.System.*;

public class Exit  {
    private static  Exit exit;
    private final WriteDataBase writeDataBase = WriteDataBase.getInstance();
    private final WriteBalanceBank writeBalanceBank = WriteBalanceBank.getInstance();

    private Exit() {
    }

    public static Exit getInstance() {
        if (exit == null) {
            exit = new Exit();
        }
        return exit;
    }
    public void exitAtm(){
        writeDataBase.updateDateBaseInfoCard();
        writeBalanceBank.updateDateBaseBalanceCart();
        System.out.println("Всего доброго");
        exit(0);
    }

}

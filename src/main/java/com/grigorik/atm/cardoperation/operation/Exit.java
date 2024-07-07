package com.grigorik.atm.cardoperation.operation;

import com.grigorik.atm.cardoperation.operation.interfaces.Operation;
import com.grigorik.atm.operatetofile.writefile.WriteBalanceBank;
import com.grigorik.atm.operatetofile.writefile.WriteDataBase;

import static java.lang.System.*;

public class Exit  implements Operation {
    private static  Exit exit;
    private  WriteDataBase writeDataBase ;
    private  WriteBalanceBank writeBalanceBank ;

    private Exit() {
    }

    public static Exit getInstance() {
        if (exit == null) {
            exit = new Exit();
        }
        return exit;
    }
    public void setPathDateBase(String pathDateBase){
        writeDataBase = WriteDataBase.getInstance(pathDateBase);
    }

    public void setPathBalanceBank(String pathBalanceBank) {
        writeBalanceBank = WriteBalanceBank.getInstance(pathBalanceBank);
    }

    public void exitAtm(){
        writeDataBase.updateDateBaseInfoCard();
        writeBalanceBank.updateBalanceBank();
        System.out.println("Всего доброго");
        exit(0);
    }
    public void exitAtmError(){
        exit(0);
    }

    @Override
    public void execute(String number) {
        exitAtm();
    }
}

package com.grigorik.atm.cardoperation;

import com.grigorik.atm.writefile.WriteDataBase;

public class Exit {
    private static Exit exit;
    private WriteDataBase writeDataBase = WriteDataBase.getInstance();

    private Exit() {
    }

    public static Exit getInstance() {
        if (exit == null) {
            exit = new Exit();
        }
        return exit;
    }
    public void exitAtm(){
        writeDataBase.updateDateBase();
        System.out.println("До свидания");
        System.exit(0);
    }

}

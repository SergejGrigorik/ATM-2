package com.grigorik.atm.operatetofile.writefile;

import com.grigorik.atm.entity.card.CardUnfo;

import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static Write write;

    private Write(){

    }
    public static Write getInstance(){
        if(write == null){
            write = new Write();
        }
        return write;
    }
    public FileWriter getFileWriter(String path) {
        try {
            return new FileWriter(path, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

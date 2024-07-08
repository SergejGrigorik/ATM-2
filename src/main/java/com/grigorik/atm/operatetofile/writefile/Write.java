package com.grigorik.atm.operatetofile.writefile;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Write {
    private String path;

    public Write(String path) {
        this.path = path;
    }

    public FileWriter getFileWriter() {
        try {
            return new FileWriter(path, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

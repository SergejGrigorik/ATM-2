package com.grigorik.atm.operatetofile.readerfile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class Read {
   private String pathFile;

    public Read (String path) {
    this.pathFile = path;
    }

    public List<String> getScanFile() throws IOException {
        Path path = Path.of( pathFile);
        return Files.readAllLines(path);
    }
}

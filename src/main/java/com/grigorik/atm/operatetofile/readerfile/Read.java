package com.grigorik.atm.operatetofile.readerfile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Read {
    public static Read read;

    private Read()  {
    }

    public static Read getInstance() {
        if (read == null) {
            read = new Read();
        }
        return read;
    }

    public List<String> getScanFile(String pathFile) throws IOException {
        Path path = Path.of( pathFile);
        return Files.readAllLines(path);
    }
}

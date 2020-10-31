package org.senolab.reportingtool.model;

import org.senolab.reportingtool.exception.NotADirectoryException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DeleteLastLine {
    File[] files;
    public DeleteLastLine(String pathToInputDir) throws NotADirectoryException {
        File inputDir = new File(pathToInputDir);
        if(inputDir.isDirectory()) {
            System.out.println("Processing file from "+inputDir.getAbsolutePath());
            files = inputDir.listFiles();
        } else {
            throw new NotADirectoryException("[DeleteLastLine] You specify the input directory which does not exist!");
        }
    }

    public void execute() {
        for(File file: files) {
            System.out.println("Delete last line from file "+file.getAbsolutePath());
            try {
                RandomAccessFile f = new RandomAccessFile(file, "rw");
                long length = f.length() - 1;
                byte b;
                do {
                    length -= 1;
                    f.seek(length);
                    b = f.readByte();
                } while (b != 10 && length > 0);
                if (length == 0) {
                    f.setLength(length);
                } else {
                    f.setLength(length + 1);
                }
            } catch (FileNotFoundException e) {
                System.out.println("[DeleteLastLine] the file specified doesn't exist");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("[DeleteLastLine] Error occurred during I/O operation. Please try again");
                e.printStackTrace();
            }
        }

    }
}

package org.senolab.reportingtool.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriterUtil {

    public static void write(String line, String file) {
        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(file), charset, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            System.out.println("Writing to file "+file);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("[FileWriterUtil] Something wrong during the write process");
            e.printStackTrace();
        }
    }
}

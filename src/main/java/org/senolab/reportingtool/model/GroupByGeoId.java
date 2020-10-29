package org.senolab.reportingtool.model;

import org.senolab.reportingtool.exception.NotADirectoryException;
import org.senolab.reportingtool.util.FileWriterUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByGeoId {
    File[] files;
    File outputDir;

    public GroupByGeoId(String pathToInputDir, String pathToOutputDir) throws NotADirectoryException {
        File inputDir = new File(pathToInputDir);
        outputDir = new File(pathToOutputDir);
        if(inputDir.isDirectory()) {
            System.out.println("Processing file from "+inputDir.getAbsolutePath());
            files = inputDir.listFiles();
        } else {
            throw new NotADirectoryException("You specify the input directory which does not exist!");
        }
        if(!outputDir.isDirectory()) {
            throw new NotADirectoryException("You specify the output directory which does not exist!");
        }
        System.out.println("Output file will be stored in "+outputDir.getAbsolutePath());
    }
    public void execute() {
        for(File ddcRptFile: files) {
            System.out.println("Reading file "+ddcRptFile.getAbsolutePath());
            try (BufferedReader reader = Files.newBufferedReader(Path.of(ddcRptFile.getAbsolutePath()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if(line.startsWith("#")) continue;
                    List<String> lines = Stream.of(line.split(",", 2))
                            .collect(Collectors.toList());
                    StringBuilder sb = new StringBuilder(outputDir.getAbsolutePath());
                    sb.append(File.separator);
                    sb.append(lines.get(0));
                    sb.append(".txt");
                    FileWriterUtil.write(line,sb.toString());
                }
            } catch (IOException e) {
                System.out.println("[GroupByGeoId] Error occurred when reading the input files");
                e.printStackTrace();
            }
        }
    }
}

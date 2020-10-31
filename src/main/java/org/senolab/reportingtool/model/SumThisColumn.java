package org.senolab.reportingtool.model;

import org.senolab.reportingtool.exception.ColumnDoesNotExistException;
import org.senolab.reportingtool.exception.NotADirectoryException;
import org.senolab.reportingtool.util.FileWriterUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumThisColumn {
    private List<Double> totalByColumn = new ArrayList<>();
    private int[] columnToSum;
    private File[] files;
    private String totalColumnInFile;

    public SumThisColumn(String pathToInputDir, String totalColumnInFile, String[] columnToSum) throws NotADirectoryException {
        File inputDir = new File(pathToInputDir);
        if(inputDir.isDirectory()) {
            System.out.println("Processing file from "+inputDir.getAbsolutePath());
            files = inputDir.listFiles();
        } else {
            throw new NotADirectoryException("[SumThisColumn] You specify the input directory which does not exist!");
        }
        this.totalColumnInFile = totalColumnInFile;
        this.columnToSum = Arrays.stream(columnToSum).mapToInt(Integer::parseInt).toArray();
        initList(totalColumnInFile);

    }

    public void execute() {
        for(File ddcRptFile: files) {
            System.out.println("Processing file "+ddcRptFile.getAbsolutePath());
            try (BufferedReader reader = Files.newBufferedReader(Path.of(ddcRptFile.getAbsolutePath()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if(line.startsWith("#")) continue;
                    List<String> lines = Stream.of(line.split(","))
                            .collect(Collectors.toList());
                    for(int i=0; i<columnToSum.length; i++) {
                        if(columnToSum[i] > lines.size()) {
                            throw new ColumnDoesNotExistException("[SumThisColumn] The column that you are trying to sum does not exist in one of the rows in "+ddcRptFile.getAbsolutePath());
                        }
                        double temp = totalByColumn.get(columnToSum[i]);
                        double temp2 = Double.parseDouble(lines.get(columnToSum[i]));
                        totalByColumn.set(columnToSum[i], temp+temp2);
                    }
                }
            } catch (IOException e) {
                System.out.println("[SumThisColumn] Error occurred when reading the input files");
                e.printStackTrace();
            } catch (ColumnDoesNotExistException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.exit(0);
            }
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(8);
            String totalLine = totalByColumn.stream()
                    .map(d -> df.format(d))
                    .collect(Collectors.joining(","));
            FileWriterUtil.write(totalLine, ddcRptFile.getAbsolutePath());
            initList(this.totalColumnInFile);
        }
    }

    private void initList(String totalColumnInFile) {
        totalByColumn.clear();
        for(int i=0; i<Integer.parseInt(totalColumnInFile); i++) {
            totalByColumn.add((double) 0);
        }
    }
}

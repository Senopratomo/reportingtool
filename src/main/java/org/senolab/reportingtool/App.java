package org.senolab.reportingtool;

import org.senolab.reportingtool.exception.NotADirectoryException;
import org.senolab.reportingtool.model.DeleteLastLine;
import org.senolab.reportingtool.model.GroupByGeoId;
import org.senolab.reportingtool.model.SumThisColumn;
import org.senolab.reportingtool.util.InstructionsUtil;

public class App {
    public static void main(String[] args) {
        if(args.length >= 1) {
            switch (args[0].toLowerCase()) {
                case "groupbygeoid":
                    if(args.length == 3) {
                        try {
                            GroupByGeoId groupByGeoId = new GroupByGeoId(args[1], args[2]);
                            groupByGeoId.execute();
                        } catch (NotADirectoryException e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                    } else {
                        InstructionsUtil.printGroupByGeoIdInstructions();
                    }
                    break;
                case "sumthiscolumn":
                    if(args.length == 1) {
                        InstructionsUtil.printSumThisColumn();
                    } else if(args.length == 4) {
                        try {
                            String[] colToSum = args[3].split(",");
                            SumThisColumn sumThisColumn = new SumThisColumn(args[1], args[2], colToSum );
                            sumThisColumn.execute();
                        } catch (NotADirectoryException e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                    } else {
                        InstructionsUtil.printInsufficientArgumentSumThisColumn();
                        InstructionsUtil.printSumThisColumn();
                    }
                    break;
                case "deletelastline":
                    if(args.length == 1) {
                        InstructionsUtil.printDeleteLastLineInstruction();
                    } else if(args.length == 2) {
                        try {
                            DeleteLastLine deleteLastLine = new DeleteLastLine(args[1]);
                            deleteLastLine.execute();
                        } catch (NotADirectoryException e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    InstructionsUtil.printIncorrectCommandMessage();
                    InstructionsUtil.printReportUtilInstructions();
                    break;
            }
        } else {
            InstructionsUtil.printReportUtilInstructions();
        }
    }
}

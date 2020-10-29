package org.senolab.reportingtool;

import org.senolab.reportingtool.exception.NotADirectoryException;
import org.senolab.reportingtool.model.GroupByGeoId;
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
                default:
                    break;
            }
        } else {
            InstructionsUtil.printReportUtilInstructions();
        }
    }
}

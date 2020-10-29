package org.senolab.reportingtool.util;

public class InstructionsUtil {

    public static void printGroupByGeoIdInstructions() {
        String message = """
        The 'GroupByGeoId' command will take a directory or folder containing Traffic by country summary report csv files,
        then it will process all the files, group together all traffic data by geoid, and store it in separate file 
        with geoid as the filename within the specified output directory. 
        It takes two arguments:
            1) the full path to the directory or folder containing the input csv. 
            2) the full path to the directory where the output file will be stored. 
               
        Example:
        Scenario:
        Process and group by geo id all traffic data within /home/user/inputdir and 
        store all the grouped output file in /home/user/outputdir/ .
        Command:
        $reportutil groupbygeoid /home/user/inputdir /home/user/outputdir/       
        """;
        System.out.println(message);
    }

    public static void printReportUtilInstructions() {
        String message = """
            The reportutil CLI consist of several modules which help mostly with Akamai reporting-related processing.
            Here are the modules:
            1. groupbygeoid
               The 'GroupByGeoId' command will take a directory or folder containing Traffic by country summary report csv files,
               then it will process all the files, group together all traffic data by geoid, and store it in separate file 
               with geoid as the filename within the specified output directory.
               For instruction on how to use it, run: 
               $reportutil groupbygeoid
            
            Any issues or improvement request, feel free to file one under the Github repo
            
            Enjoy!   
            """;
        System.out.println(message);
    }
}

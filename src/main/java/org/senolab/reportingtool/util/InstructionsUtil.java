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
            reportutil CLI v0.0.5-BETA
            
            The reportutil CLI consist of several modules which help mostly with Akamai reporting-related processing.
            Here are the modules:
            1. groupbygeoid
               The 'groupbygeoid' command will take a directory or folder containing Traffic by country summary report csv files,
               then it will process all the files, group together all traffic data by geoid, and store it in separate file 
               with geoid as the filename within the specified output directory.
               For detail instruction on how to use it, run: 
               $reportutil groupbygeoid
            
            2. sumthiscolumn
               The 'sumthiscolumn' command will take a directory or folder containing CSV file(s), number of column in each row,
               comma-separated list of number representing the column within those files which need to be sum up.   
               After summing up all values in the aforementioned column, it will write the total in the 
               last line of the file(s).
               For detail instruction on how to use it, run:
               $reportutil sumthiscolumn
            
            3. deletelastline
               The 'deletelastline' command accept one argument which is the directory where the file(s) located.
               It will delete only the last line of all file(s) in the directory specified.
               Recommended use is in tandem with 'sumthiscolumn' command which add last line with total of all numbers
               in the column.
               For detail instruction on how to use it, run:
               $reportutil sumthiscolumn    
            
            Any issues or improvement request, feel free to file one under the Github repo
            
            Enjoy!   
            """;
        System.out.println(message);
    }

    public static void printIncorrectCommandMessage() {
        String message = "The command you specified is incorrect!\n";
        System.out.println(message);
    }

    public static void printSumThisColumn() {
        String message = """
        The 'sumthiscolumn' command will take a directory or folder containing CSV file(s), number of column in each row,
        comma-separated list of number representing the column within those files which need to be sum up.   
        After summing up all values in the aforementioned column, it will write the total in the 
        last line of the file(s).
        
        It takes three arguments:
            1) the full path to the directory or folder containing the input containing 
               list comma-separated number in one line. 
               Example:
               1,1,1,1
               2,2,2,2
               3,3,3,3
               ....
            2) number of column in each row (or line).
               Each line in the file must contain the same number of column (or values).
               If a line does not contain the column number to be calculated or non-number value, it will failed execution.
            3) comma-separated list of column number which will be sum up.
               The column number starts with number 0 (zero) as the first column, 1 (one) as the second column, etc.
               
               
        Example:
        #1
        Scenario:
        Sum first and second column in all files where each line within the each file contain 5 columns 
        (means 5 number-values separated by comma) within directory /home/user/input
        Command:
        $reportutil sumthiscolumn /home/user/input 5 0,1
        
        #2
        Scenario:
        Sum all columns in all files where each line within the each file contain 3 columns 
        (means 3 number-values separated by comma) within directory /home/user/input
        Command:
        $reportutil sumthiscolumn /home/user/input 3 0,1,2      
        """;
        System.out.println(message);
    }

    public static void printInsufficientArgumentSumThisColumn() {
        String message = """
            You specified insufficient number of argument for 'sumthiscolumn' command.
            Please see below instructions and try again.
            
            """;
        System.out.println(message);
    }

    public static void printDeleteLastLineInstruction() {
        String message = """
        The 'deletelastline' command accept one argument which is the directory where the file(s) located.
        It will delete only the last line of all file(s) in the directory specified.
        Recommended use is in tandem with 'sumthiscolumn' command which add last line with total of all numbers
        in the column
        
        It takes a single argument:
            1) the full path to the directory where the file(s) located.
               It will delete only the last line of all file(s) in the directory specified.
               
        Example:
        #1
        Scenario:
        Delete last line of all files within /home/user/input
        Command:
        $reportutil deletelastline /home/user/input
        """;
        System.out.println(message);
    }
}

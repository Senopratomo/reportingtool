<h3>Report Tool & Util Processor</h3>
<hr>
<p>
This is a simple CLI to process CSV output from Geo Summary report by country. It contains multiple commands described below
</p>

<h5>Prerequisite to build from source</h5>
<ul>
    <li>Java 15 installed in the local</li>
    <li>Maven installed in local</li>
</ul>
<br>
<h5>Get started:</h5>
<ul>
    <li>Download the .zip (based on your machine OS) from the release section of this repo - https://github.com/Senopratomo/reportingtool/releases</li>
    <li>Extract it to any directory of your choice</li>
    <li>Run: reportutil_xxx/bin/reportutil</li>
    <li>It will provide instructions on how to use</li>
</ul>
<br>
<h5>How to use the CLI</h5>
<p>The reportutil CLI takes one to several arguments separated by single space depend on the command you invoke. 
The current available commands: (this will be updated as more command become available)</p>
<ul>
   <li>
      groupbygeoid<br>
      The 'GroupByGeoId' command will take a directory or folder containing Traffic by country summary report csv files,
      then it will process all the files, group together all traffic data by geoid, and store it in separate file
      with geoid as the filename within the specified output directory.<br>
      For instruction on how to use it, run:<br>
      <code>
      $reportutil groupbygeoid
      </code>
   </li>
   <li>
      sumthiscolumn<br>
      The 'sumthiscolumn' command will take a directory or folder containing CSV file(s), number of column in each row,
      comma-separated list of number representing the column within those files which need to be sum up.   
      After summing up all values in the aforementioned column, it will write the total in the 
      last line of the file(s).<br>
      For instruction on how to use it, run:<br>
      <code>
      $reportutil sumthiscolumn
      </code>
   </li>
   <li>
      deletelastline<br>
      The 'deletelastline' command accept one argument which is the directory where the file(s) located.
      It will delete only the last line of all file(s) in the directory specified.
      Recommended use is in tandem with 'sumthiscolumn' command which add last line with total of all numbers
      in the column.<br>
      For detail instruction on how to use it, run:<br>
      <code>
      $reportutil sumthiscolumn
      </code>
   </li>
</ul>
<br>
<h5>Sample Usage</h5>
<ol>
    <li>
    Scenario:<br>
    Process and group by geo id all traffic data within /home/user/inputdir and
    store all the grouped output file in /home/user/outputdir/ . <br>
    Command:<br>
    <code>
    $reportutil groupbygeoid /home/user/inputdir /home/user/outputdir/
    </code>
    </li>
    <li>
    Scenario:<br>
    Sum first and second column in all files where each line within the each file contain 5 columns 
    (means 5 number-values separated by comma) within directory /home/user/input<br>
    Command:<br>
    <code>
    $reportutil sumthiscolumn /home/user/input 5 0,1
    </code>
    </li>
    <li>
    Scenario:<br>
    Delete last line of all files within /home/user/input<br>
    Command:<br>
    <code>
    $reportutil deletelastline /home/user/input
    </code>
    </li>
       
</ol>



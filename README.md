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
       
</ol>



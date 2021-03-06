# insightdata
This Repository contains solution to Insight Data Engineering Fellowship Challenge,
( Kindly test using the provided Directory Structure or Download insightdata.Zip which has same directory structure)

# The Challenge and its Proposed Solution

To filter individual campaign donations based on zipcode and date, is one aspect and other challenges include calculating RunningMedian and TotalContribution, TotalCount for each entry from input file, The input may be large and may have dirty values for required fields. 

Solution: Divide code in three processes: Preprocessor, Processor, Output Processor to distinguish between  critical tasks at every stage, read clean values and use further only after checking boundary conditions. 

Test at every stage and maintain data flow. Optimize space complexity by using efficient data structures like Heap for Calculating RunningMedian and Hash Maps to store key value pairs, which are more efficient than using index files, as index files might require more traverslas for the same operation.

Output Calculated values Line by Line and update running values with every iteration. 

# Main Class: ReadTextFile.java

The above class contains the main function and includes calls to various components of the program. 
The various components of the program include:

Input Preprocessor: includes files -> PreProcessor.java, Campaign.java, Contribution.java

Processor: includes files-> CampaignByZip.java, CampaignByDate.java, CampaignValue.java, RunningMedianProcessor.java,             RunningMedianCalculator.java   

Output Processor: includes files->AppendToFileExample.java, WriteDate.java

# PreProcessor Design 
Considerations
Discards Null values and takes care of garbage values from input file, Extracts lines from itcont.txt to form Strings, Used to String Split function to generate tokens expected.

Output: Expected member variables for CMTE ID, ZIP,DATE,AMOUNT in Campaign Class

# Processor Design and Running Median Calculation

Processor Considers RunningMedianCalculation, Median1.java file contains the logic for the same, CampaignByZip and CampaignDate classes are used to form Hash Maps to use CMTE ID, ZIP/DATE. CampaignValue class contains members to store values of runningTotal, runningCount, runningMedian, Key contains CMTE ID or ZIP/DATE and is used extensively to write output files medianvals_by_zip.txt and medianvals_by_date.txt.

Output: Formatted Strings to Write in Output Files

# Output Processor Design

These two classes just append contents of String given line by line to outfut files

Output: Two Text files containing RunningMedian,RunningCount,RunningContributed sorted by zip/date.

# Conclusion

Challenge helped to understand various scalability scenarios, InputStream Processing, Designing Processor Components for Streams and Writing meaningful Output Streams. It also helped to understand challenges with different data structures and implementing the correct data required for processing. 




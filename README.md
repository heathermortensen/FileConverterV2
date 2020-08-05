# Overview

This repo houses Java code to convert between different file types:
* csv, [dat](https://en.wikipedia.org/wiki/List_of_file_formats#Binary_files), html, txt, xml

 

Lets convert the following .txt file into a .csv!

![Text file input](https://raw.githubusercontent.com/heathermortensen/FileConverterV2/master/images/TextFileImage.png)



### How to run the program

Not all of the possible execution paths have been implemented. 

A user can enter the following inputs (highlighted in yellow) to convert a .txt file into a .csv file. 

**Note:** Java will throw an exception if either the .txt or .csv (pops up in excel) file are not closed prior to re-running the program.

*Please close the excel popup prior to re-running the program.*

![Program Output](https://raw.githubusercontent.com/heathermortensen/FileConverterV2/master/images/ProgramOutput.png)



Running with these user inputs will popup a new excel window containing the data from the original .txt file (shown in Overview) that was converted into a .csv file.

![.csv file output](https://raw.githubusercontent.com/heathermortensen/FileConverterV2/master/images/CSVFileImage.png)



### To Do List

- [ ] Add functionality to close both files after execution.
- [ ] Handle java exceptions if either file remains open, like version 1 does.
- [ ] Gather some .xml data from dex
- [ ] Move in the exit program function from the original convertFile repo that I made. Is there any other missing functionality in this file? Make the original blah code run and see.
- [ ] Because there is an html file in this project, Github reports this as a html project, not a java one. Do I need to keep this html file here?



### Class Diagram

![Class Diagram](https://raw.githubusercontent.com/heathermortensen/FileConverterV2/master/images/ConvertFileClassDiagram.png)



### Project Improvement

The default text file converted by the program originates from a medical device called a Dexcom G4 Continuous glucose sensor.

This is a photo of comedian Tracy Morgan wearing a Dexcom sensor at the Emmys. 

![Tracy Morgan & his Dexcom sensor](https://raw.githubusercontent.com/heathermortensen/FileConverterV2/master/images/TraceyMorganImage.png)



The file stores a bunch of events entered by the user (highlighted in orange), an internal system dateTime (highlighted in light blue), an external dateTime (highlighted in dark blue), and blood glucose values read from the sensor (highlighted in red). The sensor wirelessly transmits data to a receiver. The collected data can then be exported as a .csv or a .xml file.

![TextfileImage2 describes the type of data contained in the file](https://raw.githubusercontent.com/heathermortensen/FileConverterV2/master/images/TextFileImage2.png)

![CSVFileImage2 describes the type of data contained in the file](https://raw.githubusercontent.com/heathermortensen/FileConverterV2/master/images/CSVFileImage2.png)



These files are not super valuable for a patient or a doctor in their current format. Its unusual for a medical device to allow the individual who went to all the work and expense to collect the data, to have full access to it. Dexcom is a unique and valuable device for that reason. I typically perform a lot of work to reformat this data so I can analyze it, so that I can make proper changes in my medication dosage.

It would be a useful extension of the work here, to import the data into excel and automate some of the formatting and analysis.

This is an example of what proper data formatting looks like. This program would be helpful to me if it was expanded to import sensor data into one of the 1st two columns of this spreadsheet for either G4 or G6 model sensor data.

![Blood Glucose record with proper formatting](https://raw.githubusercontent.com/heathermortensen/FileConverterV2/master/images/BGRecord.png)
# GoEuroTest
Java Developer Test

PROBLEM STATEMENT:
Create a Java command line tool that takes as an input parameter a string

java -jar GoEuroTest.jar "CITY_NAME"

The program takes this string and queries with it our Location JSON API: The app should use this API endpoint:

http://api.goeuro.com/api/v2/position/suggest/en/CITY_NAME

Where CITY_NAME is the string that the user has entered as a parameter when calling the tool, e.g.

The program should query the API with the user input and create a CSV file from it. The CSV file should have the form: _id, name, type, latitude, longitude

System Requirement
Jdk 1.6 or above
Maven 3.1.1
Min 500 MB RAM


Installation and Running
1)	Install JDK as per below instruction
https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html

2)	Install Maven as per below instructions
https://maven.apache.org/install.html


3)	Checkout the source code from below location, by clicking on Download ZIP option
https://github.com/rbutti/GoEuroTest.git

 

4)	Navigate to the zip folder location and unzip the file at the location [PROJECT_LOCATION]

5)	Navigate to the folder [PROJECT_LOCATION]\GoEuroTest\GoEuroTest\src\main\resources and open the file goeuro-application-loc2csv.properties. Make necessary changes to the file as per requirement.

NOTE : Update the value for the property “GOEURO_CSV_OUTPUT_DIRECTORY” so that the application output file gets generated at your desired location. By default the outfile is generated at C:\Data location.

6)	Open Windows Command Prompt and navigate to the location [PROJECT_LOCATION]/GoEuroTest


7)	Run the following command in command prompt
mvn clean install

This would generate the runnable jar “GoEuroTest-1.0.0-jar-with-dependencies.jar” at the location [PROJECT_LOCATION]/GoEuroTest/target

8)	In the command prompt Navigate to the location [PROJECT_LOCATION]/GoEuroTest/target and run the following command
java -jar GoEuroTest-1.0.0-jar-with-dependencies.jar  HYDERABAD


By default this would generate a file with name HYDERABAD.csv at the location C:/DATA. But if you have changed the location in step 5 please search in the update folder.

9)	Rerun the application by replacing HYDERABAD with any other city name as desired and data will be capture in the csv file named after the passed city name.




	



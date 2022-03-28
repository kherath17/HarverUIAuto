Harver UI Automation Kasun
========================

Instructions:
--
*This is a Maven Project with TestNG,Selenium-Java.
#

#
1.Please download the chromedriver.exe compatible for the browser been used and replace the path with chromedriver.exe to driverSet.java file at src/main/java/envSetup/driverSet.java line number 9 (Script is set for version 99)

2.Inside src/main/resources/Data/data.json Update the path of the Test.txt file at src/main/resources/UploadFiles/Test.txt to match your own directory, update path in line 11 and make sure to seperate paths with 2 backward slashes -> \\

3.Update the POM file to download the necessary dependencies.
#
4.Script can be run by 2 ways 

*Run TestFlow.java file at src/test/java/TestFlow.java 
 
*Run runner.xml file at src/main/resources/TestNGXML/runner.xml include or exclude test cases depending on the requirement (currently all test methods are included)
#
Prefered IDE - IntelliJ


# NAGP ASSIGNMENT FOR SELENIUM WORKSHOP


**This Project contains?**
----
*com.seleniumAssignment.framework.testcases package which includes:* :
This Package contains test cases java file. 
Having all of the information about the test steps involved in testing.

*com.seleniumAssignment.framework.base package which includes:* 
This package contains base code which is going to use in each and every test case and their corresponding page.

*com.seleniumAssignment.framework.config package which includes:* 
Contains all of the configuration related data.

*com.seleniumAssignment.framework.pages package which includes:* 
Contains pages corresponds for each and every test file.

*com.seleniumAssignment.framework.util package which includes:* 
Basic functions which can be used as utility in complete project at anywhere.


# Different testNG.xml

busTicketTest.xml

homePageTest.xml

hotelPageTest.xml

manageBookingTest.xml

pilgrimagesTest.xml

# TEST REPORT

Extent report is in test-report folder under Extent Folder.
Archive report is under ArchiveExtent folder.

# How to run test script using cmd

mvn clean test -DsuiteXmlFile=yourTestng.xml


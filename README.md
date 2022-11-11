# ProjectAutomation
Automation final project 

REQUISITOS:

JVM: 11.0.16 (Oracle Corporation 11.0.16+11-LTS-199)

OS: Windows 11 10.0 amd64

Gradle version 7.5.1

git version 2.37.3.windows.1 to clone the repository

Browsers: Chrome, Edge, Firefox, Docker


GRADLE COMMANDS:

All Tests cases = gradle clean test -PenvFile=qa.properties

Class test cases = gradle test -PenvFile=qa.properties --tests @class

TAGS Tests cases = gradle clean -x test -PenvFile=qa.properties tags -PtestSuite=@tagname


COMMANDS REPORTS: 

allure serve build\allure-results


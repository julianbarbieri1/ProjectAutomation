# ProjectAutomation
Final project 

## REQUIREMENTS:

JVM: 11.0.16 (Oracle Corporation 11.0.16+11-LTS-199)

OS: Windows 11 10.0 amd64

Gradle version 7.5.1

git version 2.37.3.windows.1 to clone the repository

Browsers: Chrome Versión 107.0.5304.107, Edge Versión 107.0.1418.35, Firefox 106.0.5, Docker version 20.10.20


## GRADLE COMMANDS:

All Tests cases = gradle clean test -PenvFile=qa.properties

Class test cases = gradle test -PenvFile=qa.properties --tests @class

TAGS Tests cases = gradle clean -x test -PenvFile=qa.properties tags -PtestSuite=@tagname


## COMMANDS REPORTS: 

allure serve build\allure-results


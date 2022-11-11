# ProjectAutomation
Automation final project 

REQUISITOS:

JVM: 11.0.16 (Oracle Corporation 11.0.16+11-LTS-199)

OS: Windows 11 10.0 amd64

Gradle version 7.5.1

git version 2.37.3.windows.1 to clone the repository

GRADLE COMMANDS:

All Tests cases = gradle clean test -PenvFile=qa.properties

TAGS Tests cases: gradle clean -x test -PenvFile=qa.properties tags -PtestSuite=@tagname

COMMANDS REPORTS: 

allure serve build\allure-results


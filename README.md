AutomateWebProject is written in JAVA using Selenium Suite. AutomateWebProject uses Maven Project Dependencies defined on the POM file.

JDK 11 and MAVEN is installed and set up correctly.

JAVA_HOME and MVN_HOME is set in the environment variables.

I have outlined the dependencies and the respective versions because there were lots of compatibility issues while testing the code in Maven.
Dependencies needed are:
      selenium-java 4.8.3
      cucumber-java 7.11.0
      cucumber-junit 7.11.0
      junit 4.13.2
      slf4j-simple 2.0.12
      selenium-devtools-v126 4.23.0 - This catered for the CDC compatibilty issues with the version of Chrome driver.
      webdrivermanager 5.3.1

Instructions to Run the Tests

Install Maven:
Ensure you have Maven installed on your system. You can download it from Maven's official website.

Project Structure:
Organize your project structure as follows:

AutomateWebProject/
├── pom.xml
└── src/
    └── test/
        └── java/
            └── StepDefinitions
                 └── BbcSportSteps.java
               └── TestRunner.java
        └── resources/
            └── Features
                 └── bbcSport.feature
			
Save All your work

Build the Project.

Run the Tests:
Open Maven GUI on IntelliJ, navigate to your project directory, and click on the following in sequence and wait for each to complete before the next should commence:
>> clean
>> validate
>> compile
>> test



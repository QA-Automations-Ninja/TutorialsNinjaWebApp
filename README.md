TutorialsNinja Automation Framework

Project Overview:
This project is a scalable test automation framework for the Tutorialsninja Demo e-commerce website.
It is built using Selenium WebDriver with Java and TestNG, following the Page Object Model (POM) design pattern (non-PageFactory).

The framework supports:
• Parallel execution
• Headless browser execution
• Cross-browser testing
• Configurable via config.properties
• CI integration with Jenkins
This framework demonstrates real-world QA automation practices for e-commerce websites and CI/CD workflows.

Tech Stack:
• Java
• Selenium WebDriver
• TestNG
• Maven
• Jenkins
• Git
• Page Object Model (POM)

Framework Features:
• Cross-browser support: Chrome, Firefox and Edge
• Headless execution for CI environments
• Parallel execution using TestNG
• Centralized BaseTest setup for reusability
• Configurable test data and environment via config.properties
• Screenshot capture on test failure
• CI/CD ready: fully integratable with Jenkins pipelines
• Organized Page Classes, Test Classes, and Utility Classes

Project Structure:
TutorialsNinjaWebApp/
│
|-- src
│ |--- main
│ │ |--- java
│ │ │ |--- base → BaseTest setup and WebDriver initialization + BasePage setup
| | | |---- config → ConfigReader setup
│ │ │ |-- pages → Page classes (By locators + actions)
│ │ │ |-- utils → TestDataUtils (For Email + Names + Phone number + Password)

│ |--- test
│ │ |-- java
│ │ │ |-- tests → Test classes using TestNG
│ │ │ |-- utilities → Helper utilities (e.g., screenshot capture, extentreportmanager)
│ │ │

│ │--- test
│ │ │--- resources
│ │ │ │--- config.properties → Contains browser, URL, headless and wait configuration
│ │ │ │--- log4j2.xml → Log configuration
│ │ │ │--- testsuite.xml → TestNG suite configuration file that controls test execution

│--- log → Records test activities for tracking and troubleshooting
│--- reports → Present results in a clear and organised format
│--- screenshots → Provide visual evidence of failed test

│--- Jenkinsfile → Defines a CI/CD pipeline for Jenkins
│--- pom.xml → Maven build file
│--- README.md → This file

Configuration (config.properties):
url=https://tutorialsninja.com/demo/
browser=chrome
implicitWait=10
headless=true
• Easily switch browsers or toggle headless mode
• Configurable timeout settings for stable test execution

How to Run Tests:
Run via Maven:
mvn clean test
Run with parameters (CI/CD pipeline):
mvn clean test -Dbrowser=chrome -Dheadless=true
Run in Parallel:
Configured via testng.xml suite file

CI/CD Integration:
• The framework is fully integrated with Jenkins for continuous integration
• Supports headless execution in CI pipelines
• Generates reports for automated builds

Sample Test Scenarios Automated:
• Registration of new users’ functionality
• Login functionality
• Logout functionality
• Forgot password functionality

Design Principles:
• Maintainable and reusable code
• Scalable for multiple browsers and environments
• Clear separation of Page Objects and Test Classes
• CI/CD compatible
• Easy to extend for additional test scenarios

Author:
Henry Agulanna (Software QA Engineer) specializing in:
• Selenium + Java automation frameworks
• TestNG & Maven project structure
• CI/CD integration with Jenkins
• Scalable and maintainable test automation solutions


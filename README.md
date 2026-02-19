TutorialsNinja Automation Framework

🚀 Project Overview
This project is a scalable test automation framework for the Tutorialsninja Demo e-commerce website.
It is built using Selenium WebDriver with Java and TestNG, following the Page Object Model (POM) design pattern (non-PageFactory).
The framework supports:
•	Parallel execution
•	Headless browser execution
•	Cross-browser testing
•	Configurable via config.properties
•	CI integration with Jenkins
This framework demonstrates real-world QA automation practices for e-commerce websites and CI/CD workflows.
________________________________________
🛠 Tech Stack
•	Java
•	Selenium WebDriver
•	TestNG
•	Maven
•	Jenkins
•	Git
•	Page Object Model (POM)
________________________________________
✨ Framework Features
•	Cross-browser support: Chrome and Edge
•	Headless execution for CI environments
•	Parallel execution using TestNG
•	Centralized BaseTest setup for reusability
•	Configurable test data and environment via config.properties
•	Screenshot capture on test failure
•	CI/CD ready: fully integratable with Jenkins pipelines
•	Organized Page Classes, Test Classes, and Utility Classes
________________________________________
📁 Project Structure
TutorialsNinjaAutomation/
│
├── src
│   ├── main
│   │    ├── java
│   │    │     ├── base        → BaseTest setup and WebDriver initialization
│   │    │     ├── pages       → Page classes (By locators + actions)
│   │    │     ├── utils       → Helper utilities (e.g., screenshot capture)
│   │
│   ├── test
│   │    ├── java
│   │    │     ├── tests       → Test classes using TestNG
│
├── config
│   └── config.properties      → Browser, URL, and wait configuration
├── pom.xml                    → Maven build file
├── testng.xml                 → TestNG suite configuration
└── README.md                  → This file
________________________________________
⚙️ Configuration (config.properties)
url=https://tutorialsninja.com/demo/
browser=chrome
implicitWait=10
headless=true
•	Easily switch browsers or toggle headless mode
•	Configurable timeout settings for stable test execution
________________________________________
▶️ How to Run Tests
Run via Maven:
mvn clean test
Run with parameters:
mvn clean test -Dbrowser=edge -Dheadless=true
Run in Parallel:
Configured via testng.xml suite file.
________________________________________
🔄 CI/CD Integration
•	The framework is fully integrated with Jenkins for continuous integration.
•	Supports headless execution in CI pipelines
•	Generates reports for automated builds
•	Enables seamless QA automation in enterprise-level workflows
________________________________________
🧪 Sample Test Scenarios Automated
•	Login / Logout functionality
•	Product search
•	Add to cart / Remove from cart
•	Checkout workflow
•	Registration of new users
•	Negative test scenarios (invalid login, empty cart checkout)
______________________________________
📌 Design Principles
•	Maintainable and reusable code
•	Scalable for multiple browsers and environments
•	Clear separation of Page Objects and Test Classes
•	CI/CD compatible
•	Easy to extend for additional test scenarios
________________________________________
👨‍💻 Author
QA Automation Engineer specializing in:
•	Selenium + Java automation frameworks
•	TestNG & Maven project structure
•	CI/CD integration with Jenkins
•	Scalable and maintainable test automation solutions


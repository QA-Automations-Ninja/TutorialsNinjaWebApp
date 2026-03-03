package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import base.BasePage;

public class LoginPage extends BasePage {
   
	public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By emailField = By.id("input-email");
    private By passwordField = By.id("input-password");
    private By loginButton = By.xpath("//input[@value='Login']");
    private By warningMessage = By.xpath("//div[contains(@class,'alert-danger')]");
    private By forgottenPasswordLink = By.xpath("//div[@class='form-group']//a[normalize-space()='Forgotten Password']");
    private By loginHeading = By.xpath("//h2[normalize-space()='Returning Customer']");
    
  
    // Page Actions
    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    
    public void clickForgottenPasswordLink() {
        driver.findElement(forgottenPasswordLink).click();
    }
    
    //Right-click password field
    public void rightClickPasswordField() {
        logger.info("Simulating right-click on password field");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(passwordField)).perform();
    }
    

    // Business Method
    public void loginWithValidCredentials(String email, String password) {
        logger.info("Performing login with valid credentials");
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    
    public void loginWithInvalidCredentials(String email, String password) {
        logger.info("Executing login with invalid credentials");
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    
    public void clickForgottenPassword() {
        logger.info("Executing business flow: Click Forgotten Password");
        clickForgottenPasswordLink();
    }
    
    
    public void attemptLoginMultipleTimes(String email, String password, int attempts) {
        logger.info("Attempting login " + attempts + " times");
        for (int i = 1; i <= attempts; i++) {
            logger.info("Login attempt number: " + i);
            loginWithInvalidCredentials(email, password);
        }
    }
    
  
    public void enterPasswordAndValidateMasking(String password) {
        logger.info("Enter password and validate masking");
        enterPassword(password);
    }
    
    
    //combine right-click + validation
    public boolean validatePasswordFieldTypeWithRightClick() {
        logger.info("Executing business flow: Right-click + validate password field type");
        rightClickPasswordField();  // simulate manual right-click
        return isPasswordFieldTypeCorrect();
    }
    
    
    // Validations
    
    public boolean isWarningDisplayed() {
        logger.info("Checking if warning message is displayed");
        
        String expected = "Warning: No match for E-Mail Address and/or Password.";
        return driver.findElement(warningMessage).isDisplayed() &&
                driver.findElement(warningMessage).getText().equals(expected);
    }
    
    public boolean isForgottenPasswordLinkDisplayed() {
        logger.info("Checking if Forgotten Password link is displayed");
        return driver.findElement(forgottenPasswordLink).isDisplayed();
    }
    
    public boolean isLoginPageDisplayed() {
        logger.info("Validating Login page is displayed");
        return driver.findElement(loginHeading).isDisplayed();
    }
    
    public boolean isAccountLockedWarningDisplayed() {
    	logger.info("Checking if Account Locked Warning Message is displayed");
 String expectedText = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
        return driver.findElement(warningMessage).isDisplayed() &&
           driver.findElement(warningMessage).getText().equals(expectedText);
    }
    
    public boolean isPasswordMasked() {
        logger.info("Validating password field type attribute");
        String fieldType = getAttribute(passwordField, "type");
        return fieldType.equalsIgnoreCase("password");
    }
    
    
    //check type="password"
    public boolean isPasswordFieldTypeCorrect() {
        logger.info("Validating password field type attribute");
        String typeAttribute = driver.findElement(passwordField).getAttribute("type");
        logger.info("Password field type attribute = " + typeAttribute);
        return "password".equalsIgnoreCase(typeAttribute);
    }
   
    
    
}
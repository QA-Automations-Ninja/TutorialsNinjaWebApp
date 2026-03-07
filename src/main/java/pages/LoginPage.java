package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    	waitForVisibility(emailField);
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
    	waitForVisibility(passwordField);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
    	waitForElementToBeClickable(loginButton);
        driver.findElement(loginButton).click();
    }
    
    public void clickForgottenPasswordLink() {
    	waitForElementToBeClickable(forgottenPasswordLink);
        driver.findElement(forgottenPasswordLink).click();
    }
    
    //Right-click password field
    public void rightClickPasswordField() {
        logger.info("Simulating right-click on password field");
        waitForVisibility(passwordField);
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
    	logger.info("Attempting login {} times", attempts);
        for (int i = 1; i <= attempts; i++) {
        	logger.info("Login attempt number: {}", i);
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
        
        waitForVisibility(warningMessage);
        WebElement warning = driver.findElement(warningMessage);
        
        String expected = "Warning: No match for E-Mail Address and/or Password.";
        return warning.isDisplayed() && warning.getText().equals(expected);
    }
    
    public boolean isForgottenPasswordLinkDisplayed() {
        logger.info("Checking if Forgotten Password link is displayed");
        waitForVisibility(forgottenPasswordLink);
        return driver.findElement(forgottenPasswordLink).isDisplayed();
    }
    
    public boolean isLoginPageDisplayed() {
        logger.info("Validating Login page is displayed");
        waitForVisibility(loginHeading);
        return driver.findElement(loginHeading).isDisplayed();
    }
    
    public boolean isAccountLockedWarningDisplayed() {
    	logger.info("Checking if Account Locked Warning Message is displayed");   
    	waitForVisibility(warningMessage);
    	 WebElement accountLockedWarning = driver.findElement(warningMessage);
    	   
   String expectedText = "Warning: Your account has exceeded allowed number of login attempts. "
 		                    + "Please try again in 1 hour.";
   return accountLockedWarning.isDisplayed() && accountLockedWarning.getText().equals(expectedText);
    }
    
    public boolean isPasswordMasked() {
        logger.info("Validating password field type attribute");
        String fieldType = getAttribute(passwordField, "type");
        return fieldType.equalsIgnoreCase("password");
    }
    
    
    //check type="password"
    	public boolean isPasswordFieldTypeCorrect() {
    	    String typeAttribute = getAttribute(passwordField, "type");
    	    logger.info("Password field type attribute = {}", typeAttribute);
    	    return "password".equalsIgnoreCase(typeAttribute);
    	} 
    
}
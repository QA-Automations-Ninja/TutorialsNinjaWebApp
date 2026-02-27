package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    
    
}
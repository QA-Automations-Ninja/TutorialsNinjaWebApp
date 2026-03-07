package pages;

import org.openqa.selenium.*;
import base.BasePage;

public class ChangePasswordPage extends BasePage {
	
	 public ChangePasswordPage(WebDriver driver) {
	        super(driver);
	    }
	 
	 //Locators

    private By passwordField = By.id("input-password");
    private By confirmPasswordField = By.id("input-confirm");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");

  
    //Page actions
    public void enterNewPassword(String newPassword) {
        logger.info("Entering New Password");

        waitForVisibility(passwordField);
        WebElement password = driver.findElement(passwordField);
        password.clear();
        password.sendKeys(newPassword);

        waitForVisibility(confirmPasswordField);
        WebElement confirmPassword = driver.findElement(confirmPasswordField);
        confirmPassword.clear();
        confirmPassword.sendKeys(newPassword);
    }

    public void clickContinueButton() {
        logger.info("Clicking Continue button");
        waitForElementToBeClickable(continueButton);
        driver.findElement(continueButton).click();
    }

    // Business Method
    public void changePassword(String newPassword) {
        logger.info("Business Flow: Change Password");
        enterNewPassword(newPassword);
        clickContinueButton();
    }

    // Validation
    public boolean isPasswordChangeSuccessful() {
        logger.info("Validating password change success message");
        waitForVisibility(successMessage);
        return !driver.findElements(successMessage).isEmpty();
    }
}
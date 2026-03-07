package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ForgottenPasswordPage extends BasePage {
	
	public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private By forgottenPasswordHeading = 
        By.xpath("//h1[normalize-space()='Forgot Your Password?']");

    

    // Validation Method
    public boolean isForgottenPasswordPageDisplayed() {
        logger.info("Validating Forgotten Password page display");
        
        waitForVisibility(forgottenPasswordHeading);
        WebElement forgottenpasswordpage = driver.findElement(forgottenPasswordHeading);
        
        String expected = "Forgot Your Password?";
        return forgottenpasswordpage.isDisplayed() && forgottenpasswordpage.getText().equals(expected);
    }
}
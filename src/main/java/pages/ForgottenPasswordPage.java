package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        
        
        return driver.findElement(forgottenPasswordHeading).isDisplayed() && 
        		driver.findElement(forgottenPasswordHeading).getText().equals("Forgot Your Password?");
    }
}
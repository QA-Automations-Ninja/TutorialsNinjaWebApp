package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LogoutPage extends BasePage{
	
	public LogoutPage(WebDriver driver) {
        super(driver);
    }

	//Locators
	private By accountLogout = By.xpath("//h1[normalize-space()='Account Logout']");
	private By continueButton = By.xpath("//a[@class='btn btn-primary']");
	
	
    //Page actions
	
	public void clickContinuebutton() {
		logger.info("Clicking continue button");
		driver.findElement(continueButton).click();
	}
		//Navigate Back
    public void navigateBack() {
        logger.info("Navigating back using browser back button");
        driver.navigate().back();
    }
    
    
    //Validations
    public boolean isLogoutSuccessful() {
        logger.info("Validating Logout is successful");
        return driver.findElement(accountLogout).isDisplayed();
    }
    
    
}

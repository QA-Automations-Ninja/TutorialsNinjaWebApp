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
	private By myAccountDropdown = By.xpath("//span[normalize-space()='My Account']");
	private By loginOption = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']");
	
	
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
    
    public void clickMyaccountDropdown() {
    	logger.info("Clicking on my account dropdown menu");
    	driver.findElement(myAccountDropdown).click();
    }
    
    
    //Validations
    public boolean isLogoutSuccessful() {
        logger.info("Validating Logout is successful");
        return driver.findElement(accountLogout).isDisplayed();
    }
    
    public boolean isLoginOptionVisible() {
        logger.info("Checking if login option is visible");
        return driver.findElement(loginOption).isDisplayed();
    }
    
    
}

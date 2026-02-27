package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class AccountPage extends BasePage {
	
	 public AccountPage(WebDriver driver) 
	 {
	     super(driver);
	 }

	 
	 //Capturing Webelements
    private By myAccountHeading = By.xpath("//h2[text()='My Account']");
    private By editAccountInfo = By.xpath("//a[normalize-space()='Edit your account information']");
    private By myAccountdropdown = By.xpath("//a[@title='My Account']");
    private By Logoutlink = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']");
    
    
    //Page Actions:
    
    public void clickEditAccountInfo() {
        logger.info("Clicking Edit Account Information");
        driver.findElement(editAccountInfo).click();
    }
    
    public void clickmyAccountdropdown() {
    	logger.info("Clicking my account dropdown menu");
    	  driver.findElement(myAccountdropdown).click();
    }
    
    public void clickLogoutlink() {
    	logger.info("Clicking on logout link");
    	  driver.findElement(Logoutlink).click();
    }


   

    // Validation
    public boolean isUserOnAccountPage() {
        logger.info("Validating Account page");
        return driver.findElement(myAccountHeading).isDisplayed();
    }


	public void navigateBack() {
		 logger.info("Navigating back using browser back button");
	        driver.navigate().back();
		
	}
}

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
    
    
    //Page Actions:
    
    public void clickEditAccountInfo() {
        logger.info("Clicking Edit Account Information");
        driver.findElement(editAccountInfo).click();
    }


   

    // Validation
    public boolean isUserOnAccountPage() {
        logger.info("Validating Account page");
        return driver.findElement(myAccountHeading).isDisplayed();
    }
}

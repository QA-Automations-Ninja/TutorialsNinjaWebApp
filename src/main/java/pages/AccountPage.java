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

   

    // Validation
    public boolean isUserOnAccountPage() {
        logger.info("Validating Account page");
        return driver.findElement(myAccountHeading).isDisplayed();
    }
}

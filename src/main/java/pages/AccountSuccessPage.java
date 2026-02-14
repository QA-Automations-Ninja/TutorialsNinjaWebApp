package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class AccountSuccessPage extends BasePage {
	
	  public AccountSuccessPage(WebDriver driver) 
	  {
	        super(driver);
	  }

	  
	  // Capturing Webelements
    private By successHeading = By.xpath("//h1[text()='Your Account Has Been Created!']");
    private By continueButton = By.linkText("Continue");

  

    // Validation
    public boolean isAccountCreated() {
        logger.info("Validating Account Success page");
        return driver.findElement(successHeading).isDisplayed();
    }

    // Page Action
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}

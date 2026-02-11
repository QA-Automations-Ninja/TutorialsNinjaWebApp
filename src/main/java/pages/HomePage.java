package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage 
{

	 public HomePage(WebDriver driver) 
	 {
	     super(driver);
	 }
	
	
     // Capturing Webelements
	private By myAccountDropdown = By.xpath("//span[text()='My Account']");
    private By registerOption = By.linkText("Register");

   

    // Page Actions
    public void clickMyAccount() {
        driver.findElement(myAccountDropdown).click();
    }

    public void clickRegister() {
        driver.findElement(registerOption).click();
    }

    // Business Method
    public RegisterPage navigateToRegisterPage() 
    {
        logger.info("Navigating to Register Page");
        clickMyAccount();
        clickRegister();
        return new RegisterPage(driver);
    }
}

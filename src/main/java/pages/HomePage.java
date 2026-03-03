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
    private By loginOption = By.xpath("//a[normalize-space()='Login']");
    private By homePageLogo = By.xpath("//div[@id='logo']/h1/a");

   

    // Page Actions
    public void clickMyAccount() {
        driver.findElement(myAccountDropdown).click();
    }

    public void clickRegister() {
        driver.findElement(registerOption).click();
    }
    
    public void clickLogin() {
    	driver.findElement(loginOption).click();
    }

    // Business Method
    public void navigateToRegisterPage() 
    {
        logger.info("Navigating to Register Page");
        clickMyAccount();
        clickRegister();
    }
    
    public void navigateToLoginPage() 
    {
        logger.info("Navigating to Login Page");
        clickMyAccount();
        clickLogin();
    }
    
    
    // Validation
    
    public boolean isHomePageDisplayed() {
        logger.info("Verify user is taken to the homepage");
        return driver.findElement(homePageLogo).isDisplayed();
    }
}

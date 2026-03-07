package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private By searchBox = By.xpath("//input[@placeholder='Search']");
    private  By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");

   

    // Page Actions
    public void clickMyAccount() {
    	waitForElementToBeClickable(myAccountDropdown);
        driver.findElement(myAccountDropdown).click();
    }

    public void clickRegister() {
    	waitForElementToBeClickable(registerOption);
        driver.findElement(registerOption).click();
    }
    
    public void clickLogin() {
    	waitForElementToBeClickable(loginOption);
    	driver.findElement(loginOption).click();
    }
    
    public void enterProductName(String productName) {
        logger.info("Entering product name");
        waitForVisibility(searchBox);
        WebElement search = driver.findElement(searchBox);
        search.clear();
        search.sendKeys(productName);
    }
    
    public void clickSearchButton() {
    	 logger.info("Click on search button");
    	 waitForElementToBeClickable(searchButton);
        driver.findElement(searchButton).click();
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
        waitForVisibility(homePageLogo);
        return driver.findElement(homePageLogo).isDisplayed();
    }
}

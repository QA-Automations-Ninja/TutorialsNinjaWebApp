package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class RegisterPage extends BasePage {
	
	public RegisterPage(WebDriver driver) 
	{
        super(driver);
    }

    // Capturing Webelements
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By newsletterYes = By.xpath("//input[@name='newsletter' and @value='1']");
    private By privacyPolicy = By.name("agree");
    private By continueButton = By.xpath("//input[@value='Continue']");

    

    // Page Actions
    public void enterFirstName(String value) 
    { 
    	driver.findElement(firstName).sendKeys(value);
    }
   
   
    public void enterLastName(String value) 
    { 
      driver.findElement(lastName).sendKeys(value);
    }
    
    
    public void enterEmail(String value) 
    { 
    	driver.findElement(email).sendKeys(value); 
    }
    
    
    public void enterTelephone(String value) 
    { 
       driver.findElement(telephone).sendKeys(value);
    }
    
    
    public void enterPassword(String value) 
    { 
       driver.findElement(password).sendKeys(value);
    }
    
    
    public void enterConfirmPassword(String value)
    { 
    	driver.findElement(confirmPassword).sendKeys(value);  
    }
    
    public void subscribeNewsletter() 
    { 
    	driver.findElement(newsletterYes).click(); 
    }
    
    public void acceptPrivacyPolicy() 
    { 
    	driver.findElement(privacyPolicy).click();
    }
    	    
    public void clickContinue() 
    
    { 
    	driver.findElement(continueButton).click(); 
    }

    
    // Business Methods
    public void registerWithMandatoryFields
   
    (String fName, String lName, String email,String phone, String pwd) 
    {

    	logger.info("Registering user with mandatory fields");
    	  
        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterTelephone(phone);
        enterPassword(pwd);
        enterConfirmPassword(pwd);
        acceptPrivacyPolicy();
        clickContinue();
    }
    
    public void registerWithAllFields
    
    (String fName, String lName, String email,String phone, String pwd) 
    {

    	logger.info("Registering user with all fields");
    	  
        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterTelephone(phone);
        enterPassword(pwd);
        enterConfirmPassword(pwd);
        subscribeNewsletter();
        acceptPrivacyPolicy();
        clickContinue();

    }
}

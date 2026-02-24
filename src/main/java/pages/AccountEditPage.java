package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountEditPage extends BasePage {
	
	 public AccountEditPage(WebDriver driver) {
	        super(driver);
	    }
	 
	
	 // Capturing Webelements
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    
    
    // Constant for input value attribute
    private static final String VALUE_ATTR = "value";
  
    // Validation Methods
    public String getFirstName() {
        logger.info("Retrieving First Name value from Edit Account page");
        return driver.findElement(firstName).getAttribute(VALUE_ATTR);
    }

    public String getLastName() {
        logger.info("Retrieving Last Name value from Edit Account page");
        return driver.findElement(lastName).getAttribute(VALUE_ATTR);
    }

    public String getEmail() {
        logger.info("Retrieving Email value from Edit Account page");
        return driver.findElement(email).getAttribute(VALUE_ATTR);
    }

    public String getTelephone() {
        logger.info("Retrieving Telephone value from Edit Account page");
        return driver.findElement(telephone).getAttribute(VALUE_ATTR);
    }
}
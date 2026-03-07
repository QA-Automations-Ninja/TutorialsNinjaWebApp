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
    
    
    // Generic method to retrieve input field value
    private String getFieldValue(By locator, String fieldName) {
    	logger.info("Retrieving {} value from Edit Account page", fieldName);
        return getAttribute(locator, "value");
    }

    // Public getters using the generic helper
    public String getFirstName() {
        return getFieldValue(firstName, "First Name");
    }

    public String getLastName() {
        return getFieldValue(lastName, "Last Name");
    }

    public String getEmail() {
        return getFieldValue(email, "Email");
    }

    public String getTelephone() {
        return getFieldValue(telephone, "Telephone");
    }

}
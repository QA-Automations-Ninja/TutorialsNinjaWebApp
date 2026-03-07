package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShoppingCartPage extends BasePage 
{

	 public ShoppingCartPage(WebDriver driver) 
	 {
	     super(driver);
	 }
	
	
  //Locators
	private By shoppingCartHeader  = By.xpath("//h1[contains(text(),'Shopping Cart')]");
	
	
	//Validations
	 public boolean isAtShoppingCartPage() {
		 logger.info("Verifying user is at the shopping cart page");
		 waitForVisibility(shoppingCartHeader);
		 WebElement shoppingcartpage = driver.findElement(shoppingCartHeader);
		 return shoppingcartpage.isDisplayed() && shoppingcartpage.getText().contains("Shopping Cart");
	    }

}

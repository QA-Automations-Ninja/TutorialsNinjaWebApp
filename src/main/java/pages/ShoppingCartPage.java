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
	private By unitPrice = By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[5]");
	private By quantity = By.xpath("//input[@value='1']");
	private By totalPrice = By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[6]");
	
	
	//Page actions
	
	 public double getUnitPrice() {
		 
		  logger.info("Fetching product unit price from Shopping Cart page");

	        waitForVisibility(unitPrice);

	        String price = driver.findElement(unitPrice).getText().replace("$","").trim();

	        return Double.parseDouble(price);
	    }

	    public int getQuantity() {
	    	
	    	 logger.info("Fetching product quantity from Shopping Cart page");

	        String qty = getAttribute(quantity, "value");

	        return Integer.parseInt(qty);
	    }

	    public double getTotalPrice() {
	    	
	    	logger.info("Fetching product total price from Shopping Cart page");

	        waitForVisibility(totalPrice);

	        String total = driver.findElement(totalPrice).getText().replace("$","").trim();

	        return Double.parseDouble(total);
	    }
	
	
	
	    //Validations
	 public boolean isAtShoppingCartPage() {
		 logger.info("Verifying user is at the shopping cart page");
		 waitForVisibility(shoppingCartHeader);
		 WebElement shoppingcartpage = driver.findElement(shoppingCartHeader);
		 return shoppingcartpage.isDisplayed() && shoppingcartpage.getText().contains("Shopping Cart");
	    }
	 
	 public boolean verifyTotalPriceCalculation() {
		 
		 logger.info("Verifying total price displayed on the shopping cart page");

	        double expected = getUnitPrice() * getQuantity();
	        double actual = getTotalPrice();
	        return Math.abs(expected - actual) < 0.01;
	    }

}

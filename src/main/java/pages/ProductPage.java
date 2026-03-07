package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class ProductPage extends BasePage 
{

	 public ProductPage(WebDriver driver) 
	 {
	     super(driver);
	 }
	
	
   //Locators
	private By addToCartButton = By.xpath("//button[@id='button-cart']");
	private By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By shoppingCartLinkInSuccessMessage = By.xpath("//a[normalize-space()='shopping cart']");
	
	
	//Page actions
	public void clickAddToCart() {
	 logger.info("Click on add to cart button");
	 waitForElementToBeClickable(addToCartButton);
       driver.findElement(addToCartButton).click();
   }
	
	public void clickShoppingCartLinkInSuccessMessage() {
		 logger.info("Click on shopping cart link in success message");
		 waitForElementToBeClickable(shoppingCartLinkInSuccessMessage);
	       driver.findElement(shoppingCartLinkInSuccessMessage).click();
	   }
	
	
	//Validations
	  public boolean isSuccessMessageDisplayed() {
		  logger.info("Verifying if success message is displayed");
		  waitForVisibility(successMessage);
	        return driver.findElement(successMessage).isDisplayed();
	    }

}

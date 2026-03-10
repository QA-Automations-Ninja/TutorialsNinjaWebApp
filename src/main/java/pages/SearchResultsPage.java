package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class SearchResultsPage extends BasePage 
{

	 public SearchResultsPage(WebDriver driver) 
	 {
	     super(driver);
	 }
	
	
    //Locators
	private By productLink = By.xpath("//img[@title='iMac']");
	private By addToCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
	private By shoppingCartLink = By.xpath("//a[normalize-space()='shopping cart']");
	private By cartButton = By.xpath("//span[@id='cart-total']");
	private By viewCartOption = By.xpath("//strong[normalize-space()='View Cart']");
    private By iphoneproductLink = By.xpath("//img[@title='iPhone']");
	
	
	//Page actions
	public void clickProduct() {
		 logger.info("Click on product displayed on the search result");
		 waitForElementToBeClickable(productLink);
        driver.findElement(productLink).click();
    }
	
	  public void clickAddToCart() {
	 logger.info("Click on add to cart button displayed on the search result page");
	 waitForElementToBeClickable(addToCartButton);
     driver.findElement(addToCartButton).click();
 }
	  
	  public void clickShoppingCartLink() {
		  logger.info("Click on shopping cart link ");
		  waitForElementToBeClickable(shoppingCartLink);
		     driver.findElement(shoppingCartLink).click();
	  }
	  
	  public void clickCartButton() {
			 logger.info("Click on cart button");
			  waitForElementToBeClickable(cartButton);
		     driver.findElement(cartButton).click();
		 }
	  
	  public void clickViewCart() {
		  logger.info("Click on view cart");
		  waitForElementToBeClickable(viewCartOption);
		  driver.findElement(viewCartOption).click();
	  }
	  
	  public void clickiphoneProduct() {
			 logger.info("Click on the iphone product displayed on the search result");
			 waitForElementToBeClickable(iphoneproductLink);
	        driver.findElement(iphoneproductLink).click();
	    }


}

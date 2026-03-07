package shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

public class ShoppingCartFromSuccessMessageTest extends BaseTest{
	
	 @Test
	    public void verifyNavigatingToShoppingCartPageFromSuccessMessage() {
		 
		 logger.info("Test starts: Verify navigating to shopping cart page from the success message");
	        
		    HomePage homepage= new HomePage(getDriver());
		    SearchResultsPage searchResults = new SearchResultsPage(getDriver());
		    ProductPage productPage = new ProductPage(getDriver());
		    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
		    
		    homepage.enterProductName("iMac");
		    homepage.clickSearchButton();

		    searchResults.clickProduct();

	        productPage.clickAddToCart();

	        Assert.assertTrue(productPage.isSuccessMessageDisplayed(), "Success message is not displayed");
	        productPage.clickShoppingCartLinkInSuccessMessage();

	        Assert.assertTrue(shoppingCartPage.isAtShoppingCartPage(), "User is not on Shopping Cart page");
	        
	        logger.info("Test completed successfully");
	    }


}

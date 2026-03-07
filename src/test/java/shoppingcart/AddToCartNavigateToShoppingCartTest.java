package shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

public class AddToCartNavigateToShoppingCartTest extends BaseTest{
	
	 @Test
	    public void verifyShoppingCartNavigationFromSearchPage() {
		 
		 logger.info("Test starts: Verify navigating to shopping cart page from the search result page");
	        
		    HomePage homepage= new HomePage(getDriver());
		    SearchResultsPage searchResults = new SearchResultsPage(getDriver());
		    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
		    
		    homepage.enterProductName("iMac");
		    homepage.clickSearchButton();

		    searchResults.clickAddToCart();
            searchResults.clickShoppingCartLink();

	        Assert.assertTrue(shoppingCartPage.isAtShoppingCartPage(), "User is not on Shopping Cart page");
	        
	        logger.info("Test completed successfully");
	    }


}

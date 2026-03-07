package shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

public class ViewCartNavigationTest extends BaseTest {

    @Test
    public void verifyViewCartNavigationOption() {
    	
    	 logger.info("Test starts: View cart navigation option");

        HomePage homePage = new HomePage(getDriver());
        SearchResultsPage searchResults = new SearchResultsPage(getDriver());
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
        
        homePage.enterProductName("imac");
        homePage.clickSearchButton();
        
        searchResults.clickAddToCart();
        searchResults.clickCartButton();
        searchResults.clickViewCart();

        Assert.assertTrue(shoppingCartPage.isAtShoppingCartPage(),
                "Shopping Cart page is not displayed");
        
        logger.info("Test completed successfully");
    }
}
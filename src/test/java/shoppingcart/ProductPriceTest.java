package shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

public class ProductPriceTest extends BaseTest{

	    @Test
	    public void verifyProductUnitPriceAndTotalPrice() {
	    	
	    	 logger.info("Test starts: Verify product unit and total price");

			 HomePage homePage = new HomePage(getDriver());
			 SearchResultsPage resultsPage = new SearchResultsPage(getDriver());
			 ProductPage productPage = new ProductPage(getDriver());
			 ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());

	        homePage.searchProduct("iphone");

	        resultsPage.clickiphoneProduct();

	        productPage.addProductToCartAndOpenCart();

	        Assert.assertTrue(shoppingCartPage.verifyTotalPriceCalculation(),
	                "Total price is not equal to Unit Price × Quantity");
	        
	        logger.info("Test completed: Verify product unit and total price");
	    }
	

}

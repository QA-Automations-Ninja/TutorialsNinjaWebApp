package shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

public class ProductNameAndModelTest extends BaseTest{

	    @Test
	    public void VerifyProductNameAndModel() {
	    	
	    	 logger.info("Test starts: Verify product name and model");

			 HomePage homePage = new HomePage(getDriver());
			 SearchResultsPage resultsPage = new SearchResultsPage(getDriver());
			 ProductPage productPage = new ProductPage(getDriver());
			 ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());

	        homePage.searchProduct("iphone");

	        resultsPage.clickiphoneProduct();

	        productPage.addProductToCartAndOpenCart();
	        
	        String actualName = shoppingCartPage.getProductName();
	        String actualModel = shoppingCartPage.getProductModel();

	        Assert.assertTrue(actualName.equalsIgnoreCase("iPhone"),
	                "Product name mismatch in cart");

	        Assert.assertTrue(actualModel.equalsIgnoreCase("product 11"),
	                "Product model mismatch in cart");
	        
	        logger.info("Test completed: Verify product name and model");
	    }
	

}

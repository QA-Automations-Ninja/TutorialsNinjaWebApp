package registertests;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import base.BaseTest;
	import pages.HomePage;
	import pages.RegisterPage;

	public class RegisterPasswordMismatchTest extends BaseTest {

	    @Test
	    public void verifyRegisteringWithDifferentPasswords() {

	        logger.info("Starting Test: Register With Password Mismatch");

	        HomePage homePage = new HomePage(getDriver());
	        homePage.navigateToRegisterPage();

	        RegisterPage registerPage = new RegisterPage(getDriver());

	        registerPage.registerWithPasswordMismatch(
	                "John",
	                "Doe",
	                "john" + System.currentTimeMillis() + "@mail.com",
	                "1234567890",
	                "12345",
	                "abcde"
	        );

	       
	        // ===== Validations =====
	        logger.info("Validating Password Mismatch warning Message");
	        
	        Assert.assertTrue(
	                registerPage.isPasswordMismatchWarningDisplayed(),
	                "Password mismatch warning message is not displayed correctly."
	        );

	        logger.info("Test Completed Successfully");
	    }
	}



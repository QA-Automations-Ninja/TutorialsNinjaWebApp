package registertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterWithEmptyFieldsTest extends BaseTest {

	    @Test
	    public void verifyMandatoryFieldWarningsWhenSubmittingEmptyForm() {

	        logger.info("Start Navigating To Register Page");

	        HomePage homePage = new HomePage(getDriver());
            homePage.navigateToRegisterPage();
            

	        logger.info("Starting RegisterWithEmptyFields");
            
            RegisterPage registerPage = new RegisterPage(getDriver());

	        registerPage.submitEmptyRegistrationForm();

	        // ===== Validations =====
	        logger.info("Validating First Name warning");
	        Assert.assertTrue(registerPage.isFirstNameWarningDisplayed());
	        
	        logger.info("Validating Last Name warning");
	        Assert.assertTrue(registerPage.isLastNameWarningDisplayed());
	        
	        logger.info("Validating Email warning");
	        Assert.assertTrue(registerPage.isEmailWarningDisplayed());
	        
	        logger.info("Validating Telephone warning");
	        Assert.assertTrue(registerPage.isTelephoneWarningDisplayed());
	        
	        logger.info("Validating Password warning");
	        Assert.assertTrue(registerPage.isPasswordWarningDisplayed());
	        
	        logger.info("Validating Privacy warning");
	        Assert.assertTrue(registerPage.isPrivacyPolicyWarningDisplayed());
	        
	        logger.info("Test Completed Successfully");
	}
}
	
	
	
	
	
	


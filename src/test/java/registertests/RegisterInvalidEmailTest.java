package registertests;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import utilities.DataProviders;
import utils.TestDataUtil;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegisterInvalidEmailTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(RegisterInvalidEmailTest.class);

    @Test(dataProvider = "invalidEmails", dataProviderClass=DataProviders.class)
    public void verifyRegisterWithInvalidEmail(String invalidEmail) {

    	logger.info("Starting test for invalid email: {}", invalidEmail);


        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());

        homePage.navigateToRegisterPage();
        registerPage.registerWithInvalidEmail(
        		
        		 TestDataUtil.getRandomFirstName(),
                 TestDataUtil.getRandomLastName(),
                 invalidEmail,
                 TestDataUtil.getRandomPhoneNumber(),
                 TestDataUtil.getStrongPassword()
         );
        
        
        logger.info("Check the page heading is still 'Register Account");
        
        String pageHeading = registerPage.getPageHeading();
        Assert.assertEquals(pageHeading, "Register Account", "ERROR: Unexpected page after registration!");

        logger.info("Test completed for invalid email: {}", invalidEmail);
    }
}


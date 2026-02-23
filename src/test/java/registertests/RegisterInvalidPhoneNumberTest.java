package registertests;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import utilities.DataProviders;
import utils.TestDataUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterInvalidPhoneNumberTest extends BaseTest {

    @Test(dataProvider = "invalidPhoneNumbers", dataProviderClass=DataProviders.class)
    public void verifyRegisterWithInvalidPhoneNumbers(String invalidPhoneNumber) {

    	logger.info("Starting test for invalid email: {}", invalidPhoneNumber);


        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());

        homePage.navigateToRegisterPage();
        registerPage.registerWithInvalidPhoneNumber(
        		
        		 TestDataUtil.getRandomFirstName(),
                 TestDataUtil.getRandomLastName(),
                 TestDataUtil.getRandomEmail(),
                 invalidPhoneNumber,
                 TestDataUtil.getStrongPassword()
         );
        
        
        logger.info("Check the page heading is still 'Register Account");
        
        String pageHeading = registerPage.getPageHeading();
        Assert.assertEquals(pageHeading, "Register Account", "ERROR: Unexpected page after registration!");

        logger.info("Test completed for invalid email: {}", invalidPhoneNumber);
    }
}


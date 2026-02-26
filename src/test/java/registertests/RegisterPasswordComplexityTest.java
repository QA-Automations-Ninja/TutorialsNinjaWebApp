 package registertests;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import utilities.DataProviders;
import utils.TestDataUtil;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterPasswordComplexityTest extends BaseTest {

    @Test(dataProvider = "weakPasswords", dataProviderClass=DataProviders.class)
    public void verifyPasswordComplexity(String weakPassword) {

        logger.info("Starting test with weak password: {}", weakPassword);

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.attemptRegistrationWithWeakPassword(
        		
       		    TestDataUtil.getRandomFirstName(),
                TestDataUtil.getRandomLastName(),
                TestDataUtil.getRandomEmail(),
                TestDataUtil.getRandomPhoneNumber(),
                weakPassword
        );
       

        Assert.assertEquals(
                registerPage.getPageHeading(),
                "Register Account", "ERROR: Unexpected page after registration!");

        logger.info("Validation successful for password: {}", weakPassword);
    }
}
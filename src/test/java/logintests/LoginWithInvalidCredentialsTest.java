package logintests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataProviders;

public class LoginWithInvalidCredentialsTest extends BaseTest {

    @Test(dataProvider = "invalidLoginData", dataProviderClass=DataProviders.class)
    public void verifyLoginWithInvalidCredentials(String email, String password) {
    	
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.navigateToLoginPage();

        loginPage.loginWithInvalidCredentials(email, password);
        
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(loginPage.isWarningDisplayed(), "Warning message is not displayed");
       
        softAssert.assertAll();

        logger.info("===== Negative Login Test Completed =====");
    }

    
}
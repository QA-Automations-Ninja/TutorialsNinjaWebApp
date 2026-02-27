package logintests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import pages.HomePage;
import pages.LoginPage;
import pages.AccountPage;

public class LoginWithValidCredentialsTest extends BaseTest {

    @Test
    public void verifyLoginWithValidCredentials() {
    	
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        homePage.navigateToLoginPage();
        
     // Fetch credentials from config file
        String email = ConfigReader.get("email");
        String password = ConfigReader.get("password");


        loginPage.loginWithValidCredentials(
        		email, 
        		password
        );

        Assert.assertTrue(accountPage.isUserOnAccountPage(),
                "User is NOT navigated to Account page");

        logger.info("===== Test Completed Successfully =====");
    }
}
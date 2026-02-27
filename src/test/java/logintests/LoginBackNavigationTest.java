package logintests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import pages.HomePage;
import pages.LoginPage;
import pages.AccountPage;

public class LoginBackNavigationTest extends BaseTest {

    @Test
    public void verifyLoginAndBrowserBackNavigation() {

        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        homePage.navigateToLoginPage();
        
        
        // Fetch credentials from config file
           String email = ConfigReader.get("email");
           String password = ConfigReader.get("password");

        loginPage.loginWithValidCredentials(email, password);

        // Validate successful login
        Assert.assertTrue(accountPage.isUserOnAccountPage(),
                "User is not on Account page after login");

        //Browser Back
        accountPage.navigateBack();

        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "User did not return to Login page after clicking browser back");

        logger.info("===== Test Completed Successfully =====");
    }
}
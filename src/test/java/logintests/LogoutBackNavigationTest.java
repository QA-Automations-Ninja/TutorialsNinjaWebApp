package logintests;

import base.BaseTest;
import config.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class LogoutBackNavigationTest extends BaseTest {

    @Test
    public void verifyLogoutAndBrowserBackNavigation() {

        logger.info("Starting Test: Logout and Back Navigation");

        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());
        LogoutPage logoutPage = new LogoutPage(getDriver());

        homePage.navigateToLoginPage();
        
     // Fetch credentials from config file
        String email = ConfigReader.get("email");
        String password = ConfigReader.get("password");

        loginPage.loginWithValidCredentials(email, password);

        Assert.assertTrue(accountPage.isUserOnAccountPage(),
                "Login failed - Account page not displayed");

        accountPage.clickmyAccountdropdown();
        accountPage.clickLogoutlink();

        Assert.assertTrue(logoutPage.isLogoutSuccessful(),
                "Logout was not successful");

        accountPage.navigateBack();

        accountPage.clickEditAccountInfo();

        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "User was not redirected to login page after back navigation");

        logger.info("Test Completed Successfully");
    }
}

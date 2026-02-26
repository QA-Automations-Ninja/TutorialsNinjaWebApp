package logintests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
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

        loginPage.loginWithValidCredentials(
                "automationninja82@gmail.com",
                "Password123"
        );

        Assert.assertTrue(accountPage.isUserOnAccountPage(),
                "User is NOT navigated to Account page");

        logger.info("===== Test Completed Successfully =====");
    }
}
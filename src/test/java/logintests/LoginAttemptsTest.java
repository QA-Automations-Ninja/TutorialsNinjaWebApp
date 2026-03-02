package logintests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import config.ConfigReader;
import pages.HomePage;
import pages.LoginPage;

public class LoginAttemptsTest extends BaseTest {

    @Test
    public void verifyNumberOfUnsuccessfulLoginAttempts() {

        logger.info("Test Started: Verify number of unsuccessful login attempts");

        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.navigateToLoginPage();
        
        String email = ConfigReader.get("email");

        loginPage.attemptLoginMultipleTimes(
        		 email,
                "abc123",
                6
        );

        Assert.assertTrue(
                loginPage.isAccountLockedWarningDisplayed(),
                "Account lock warning message is not displayed!"
        );

        logger.info("Test Completed Successfully");
    }
}
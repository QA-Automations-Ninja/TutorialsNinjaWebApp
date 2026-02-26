package logintests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ForgottenPasswordPage;

public class ForgottenPasswordLinkTest extends BaseTest {

    @Test
    public void verifyForgottenPasswordLinkIsClickable() {

        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        ForgottenPasswordPage forgottenPage =
                new ForgottenPasswordPage(getDriver());

        homePage.navigateToLoginPage();

        Assert.assertTrue(loginPage.isForgottenPasswordLinkDisplayed(),
                "Forgotten Password link is NOT displayed");

        loginPage.clickForgottenPassword();

        // Validate navigation
        Assert.assertTrue(forgottenPage.isForgottenPasswordPageDisplayed(),
                "User is NOT navigated to Forgotten Password page"
        );

        logger.info("===== Test Completed Successfully =====");
    }
}
package logintests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginPasswordMaskTest extends BaseTest {

    @Test
    public void verifyPasswordFieldTextIsHidden() {

        logger.info("Test Started: Verify Password Field Masking");

        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.navigateToLoginPage();

        loginPage.enterPasswordAndValidateMasking("Test@123");

        Assert.assertTrue(
                loginPage.isPasswordMasked(),
                "Password field is NOT masked. Type attribute is incorrect."
        );

        logger.info("Test Completed Successfully");
    }
}
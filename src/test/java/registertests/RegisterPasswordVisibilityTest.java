package registertests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterPasswordVisibilityTest extends BaseTest {

    @Test
    public void verifyPasswordFieldsAreHidden() {

        logger.info("===== Starting Test: Verify Password Fields Are Hidden =====");

        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());

        homePage.navigateToRegisterPage();

        registerPage.enterPasswordDetails("Test123");

        // Validation
        Assert.assertTrue(registerPage.isPasswordHidden(), "Password fields are not hidden!");

        logger.info("===== Test Completed Successfully =====");
    }
}
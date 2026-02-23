package registertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterWithExistingEmailTest extends BaseTest {

    @Test
    public void verifyRegisteringWithExistingEmail() {

        logger.info("Starting Test: Register With Existing Email");

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(getDriver());

        registerPage.registerWithExistingEmail(
                "Henry",
                "Agulanna",
                "automationninja82@gmail.com",
                "0123456789",
                "Test123"
        );
        

        // ===== Validations =====
        logger.info("Validating Existing email warning Message");

        Assert.assertTrue(
                registerPage.isExistingEmailWarningDisplayed(),
                "Existing email warning message is not displayed."
        );

        logger.info("Test Completed Successfully");
    }
}

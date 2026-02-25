package registertests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.util.UUID;

public class RegisterPasswordConfirmValidationTest extends BaseTest {

    @Test
    public void verifyRegisteringWithoutPasswordConfirmField() {

        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());

        homePage.navigateToRegisterPage();

        String uniqueEmail = "user" + UUID.randomUUID() + "@testmail.com";

        registerPage.registerWithoutPasswordConfirm(
                "John",
                "Mike",
                uniqueEmail,
                "0123456789",
                "Test123"
        );

        Assert.assertTrue(registerPage.isPasswordConfirmWarningDisplayed(),
                "Password confirmation warning message is NOT displayed!");

        logger.info("===== TEST COMPLETED SUCCESSFULLY =====");
    }
}
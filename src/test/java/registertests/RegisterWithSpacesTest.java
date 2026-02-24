package registertests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterWithSpacesTest extends BaseTest {

    @Test
    public void verifyRegistrationWithSpacesFails() {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.registerWithSpaces(
                        "  ",
                        "  ",
                        "  ",
                        "  ",
                        "  "
                );

        // ===== Validation =====
   Assert.assertEquals(registerPage.getPageHeading(), "Register Account", "ERROR: Unexpected page after registration!");

        logger.info("Test completed: Registration with spaces blocked successfully");
    }
}
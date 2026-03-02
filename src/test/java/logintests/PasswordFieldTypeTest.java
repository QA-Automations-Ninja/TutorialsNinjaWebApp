package logintests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordFieldTypeTest extends BaseTest {

    @Test
    public void verifyPasswordFieldTypeWithRightClick() {
        logger.info("START TEST: Verify Password Field Type is 'password' with Right-Click");

        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.navigateToLoginPage();

        boolean isPasswordTypeCorrect = loginPage.validatePasswordFieldTypeWithRightClick();

        // Assertion
        Assert.assertTrue(isPasswordTypeCorrect, "Password field type is NOT 'password'!");

        logger.info("END TEST: Verify Password Field Type is 'password' with Right-Click");
    }
}
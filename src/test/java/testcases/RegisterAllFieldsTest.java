package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.TestDataUtil;

public class RegisterAllFieldsTest extends BaseTest {

    @Test
    public void verifyRegisterWithAllFields() {

        logger.info("Starting Register test with all fields");

        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = homePage.navigateToRegisterPage();

        AccountSuccessPage successPage = registerPage.registerWithAllFields(
                        TestDataUtil.getRandomFirstName(),
                        TestDataUtil.getRandomLastName(),
                        TestDataUtil.getRandomEmail(),
                        TestDataUtil.getRandomPhoneNumber(),
                        TestDataUtil.getStrongPassword()
                );

        Assert.assertTrue(successPage.isAccountCreated(),
                "Account Success page not displayed");

        AccountPage accountPage = successPage.clickContinue();

        Assert.assertTrue(accountPage.isUserOnAccountPage(),
                "User not navigated to Account page");
    }
}

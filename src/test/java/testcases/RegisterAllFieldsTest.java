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
        homePage.navigateToRegisterPage();
        
        RegisterPage registerPage= new RegisterPage(getDriver());

        registerPage.registerWithAllFields(
                        TestDataUtil.getRandomFirstName(),
                        TestDataUtil.getRandomLastName(),
                        TestDataUtil.getRandomEmail(),
                        TestDataUtil.getRandomPhoneNumber(),
                        TestDataUtil.getStrongPassword()
                );
        
        AccountSuccessPage successPage = new AccountSuccessPage(getDriver());

        Assert.assertTrue(successPage.isAccountCreated(),
                "Account Success page not displayed");
        
        successPage.clickContinue();

        AccountPage accountPage = new AccountPage(getDriver());

        Assert.assertTrue(accountPage.isUserOnAccountPage(),
                "User not navigated to Account page");
    }
}

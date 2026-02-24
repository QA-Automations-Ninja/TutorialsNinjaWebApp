package registertests;

import base.BaseTest;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.TestDataUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUsingKeyboardTest extends BaseTest {

    @Test
    public void verifyRegisterUsingKeyboardKeys() {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToRegisterPage();
        
        RegisterPage registerPage = new RegisterPage(getDriver());

        registerPage.registerUsingKeyboard(
        		TestDataUtil.getRandomFirstName(),
                TestDataUtil.getRandomLastName(),
                TestDataUtil.getRandomEmail(),
                TestDataUtil.getRandomPhoneNumber(),
                TestDataUtil.getStrongPassword()
        );
        

        logger.info("===== User navigating to account page =====");
        
        AccountSuccessPage successPage = new AccountSuccessPage(getDriver());
        
        Assert.assertTrue(successPage.isAccountCreated(),
                "Account Success page was not displayed");
        
        successPage.clickContinue();

        AccountPage accountPage = new AccountPage(getDriver());

        Assert.assertTrue(accountPage.isUserOnAccountPage(),
                "User not navigated to Account page");

        logger.info("===== Test Completed Successfully =====");
    }
}
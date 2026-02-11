package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.TestDataUtil;

public class RegisterMandatoryFieldsTest extends BaseTest {


	@Test
    public void verifyRegisterWithMandatoryFields() {

        logger.info("Starting Register test with mandatory fields");

        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = homePage.navigateToRegisterPage();
        
        String firstName = TestDataUtil.getRandomFirstName();
        String lastName = TestDataUtil.getRandomLastName();
        String email = TestDataUtil.getRandomEmail();
        String phone = TestDataUtil.getRandomPhoneNumber();
        String password = TestDataUtil.getStrongPassword();

        AccountSuccessPage successPage = registerPage.registerWithMandatoryFields(
                        firstName,
                        lastName,
                        email,
                        phone,
                        password
                );

        Assert.assertTrue(successPage.isAccountCreated(),
                "Account Success page not displayed");

        AccountPage accountPage = successPage.clickContinue();

        Assert.assertTrue(accountPage.isUserOnAccountPage(),
                "User not navigated to Account page");
    }
}

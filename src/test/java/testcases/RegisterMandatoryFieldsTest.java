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
        
        homePage.navigateToRegisterPage();
        
        RegisterPage registerPage= new RegisterPage(getDriver());
        
        String firstName = TestDataUtil.getRandomFirstName();
        String lastName = TestDataUtil.getRandomLastName();
        String email = TestDataUtil.getRandomEmail();
        String phone = TestDataUtil.getRandomPhoneNumber();
        String password = TestDataUtil.getStrongPassword();

        registerPage.registerWithMandatoryFields(
                        firstName,
                        lastName,
                        email,
                        phone,
                        password
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

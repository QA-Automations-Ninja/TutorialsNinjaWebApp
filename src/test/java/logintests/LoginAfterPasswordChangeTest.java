package logintests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import config.ConfigReader;
import pages.AccountPage;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginAfterPasswordChangeTest extends BaseTest {

    @Test
    public void verifyLoginAfterPasswordChange() {

        logger.info("===== TEST STARTED =====");
        
        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());
        ChangePasswordPage changePwd = new ChangePasswordPage(getDriver());
        LogoutPage logoutPage = new LogoutPage(getDriver());

        String email = ConfigReader.get("email");
        String oldPassword = ConfigReader.get("password");
        String newPassword = "test123";

        // Initial Login
        homePage.navigateToLoginPage();
        loginPage.loginWithValidCredentials(email, oldPassword);
      

        // Change Password
        accountPage.clickChangePassword();
        changePwd.changePassword(newPassword);
        softAssert.assertTrue(changePwd.isPasswordChangeSuccessful());

        // Logout
        accountPage.accountLogout();
        logoutPage.clickContinueButton();

        // Login using old credentials
        homePage.navigateToLoginPage();
        loginPage.loginWithInvalidCredentials(email, oldPassword);
        softAssert.assertTrue(loginPage.isWarningDisplayed(),
                "User was able to login with old credentials!");

        // Login using new credentials
        loginPage.loginWithValidCredentials(email, newPassword);
        softAssert.assertTrue(accountPage.isUserOnAccountPage(),
                "User unable to login with new credentials!");
        
        softAssert.assertAll();

        logger.info("===== TEST COMPLETED SUCCESSFULLY =====");
    }
}
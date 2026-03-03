package logout_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import config.ConfigReader;
import pages.*;

public class LogoutBrowseBackTest extends BaseTest {

    @Test
    public void verifyLogoutAndBrowseBack() {

        logger.info("Starting Test: Verify logging out and browsing back");

        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        LogoutPage logoutPage = new LogoutPage(getDriver());
        AccountPage accountPage =new AccountPage(getDriver());

        
        String email = ConfigReader.get("email");
        String pwd = ConfigReader.get("password");

        //Login
        homePage.navigateToLoginPage();
        loginPage.loginWithValidCredentials(email, pwd);

        //Account logout
        accountPage.accountLogout();

        //Browser Back
        logoutPage.navigateBack();
      
        //Clicking on edit your account information
        accountPage.clickEditAccountInfo();

        //Validation
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "User session restored after logout");

        logger.info("Test Completed Successfully");
    }
}
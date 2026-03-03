package logout_tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseTest;
import config.ConfigReader;
import pages.*;

public class LogoutFromMyAccountDropdownTest extends BaseTest {

    @Test
    public void verifyLogoutFromMyAccountDropdown() {

        logger.info("Starting Test: Verify Logging out via My Account dropdown menu");

        SoftAssert softAssert = new SoftAssert();

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
        
        //CheckinglLogin option visibility
        logoutPage.clickMyaccountDropdown();
        softAssert.assertTrue(logoutPage.isLoginOptionVisible(), "Failed: Login option not visible after logout");
        

       //Click Continue button and verify user is taken to the homepage
        logoutPage.clickContinuebutton();
        
        softAssert.assertTrue(
                homePage.isHomePageDisplayed(), "Failed: Home page not displayed after clicking Continue");

        softAssert.assertAll();

        logger.info("Test Completed: Verify Logging out via My Account dropdown menu");
    }
}
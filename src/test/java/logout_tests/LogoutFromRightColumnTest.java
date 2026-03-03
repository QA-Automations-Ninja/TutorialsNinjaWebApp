package logout_tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseTest;
import config.ConfigReader;
import pages.*;

public class LogoutFromRightColumnTest extends BaseTest {

    @Test
    public void verifyLogoutOptionFromRightColumn() {

        logger.info("Starting Test: Verify Logout option from the right column");

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
        accountPage.clickLogoutFromRightColumn();
        
        //CheckinglLogin option visibility
        logoutPage.clickMyaccountDropdown();
        softAssert.assertTrue(logoutPage.isLoginOptionVisible(), "Failed: Login option not visible after logout");
        

       //Click Continue button and verify user is taken to the homepage
        logoutPage.clickContinuebutton();
        
        softAssert.assertTrue(
                homePage.isHomePageDisplayed(), "Failed: Home page not displayed after clicking Continue");

        softAssert.assertAll();

        logger.info("Test Completed: Verify Logout option from the right column");
    }
}
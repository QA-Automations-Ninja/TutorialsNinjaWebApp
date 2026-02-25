package registertests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import utils.TestDataUtil;

public class RegisterWithoutPrivacyPolicyTest extends BaseTest {

    @Test
    public void verifyRegisterWithoutPrivacyPolicyCheckbox() {

        HomePage home = new HomePage(getDriver());
        RegisterPage register = new RegisterPage(getDriver());

        home.navigateToRegisterPage();

        register.registerWithoutPrivacyPolicy(
        		 TestDataUtil.getRandomFirstName(),
                 TestDataUtil.getRandomLastName(),
                 TestDataUtil.getRandomEmail(),
                 TestDataUtil.getRandomPhoneNumber(),
                 TestDataUtil.getStrongPassword()
        );

          logger.info("Validating Privacy warning message");
          
        boolean actualWarning = register.isPrivacyPolicyWarningDisplayed();

        Assert.assertTrue(actualWarning, "Privacy Policy warning message not displayed!");
        
        logger.info("Test completed successfully...");
    }
}
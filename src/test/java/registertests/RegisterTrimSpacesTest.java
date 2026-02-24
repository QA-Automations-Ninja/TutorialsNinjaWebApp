package registertests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.*;

public class RegisterTrimSpacesTest extends BaseTest {

    @Test
    public void verifyLeadingTrailingSpacesAreTrimmed() {

        HomePage home = new HomePage(getDriver());
        RegisterPage register = new RegisterPage(getDriver());
        AccountSuccessPage success = new AccountSuccessPage(getDriver());
        AccountEditPage edit = new AccountEditPage(getDriver());
        AccountPage accountpage = new AccountPage(getDriver());

        String firstName = "  John  ";
        String lastName = "  Joe  ";
        String email = "  johnjoe245@gmail.com  ";
        String phone = "  0123456789  ";
        String password = "Test@123";

        home.navigateToRegisterPage();
        register.registerUserWithLeadingAndTrailingSpaces(firstName, lastName, email, phone, password);

        Assert.assertTrue(success.isAccountCreated(), "Account not created");

        success.clickContinue();
        accountpage.clickEditAccountInfo();
        
        SoftAssert softAssert = new SoftAssert();

        // Soft assertions for all fields
        softAssert.assertEquals(edit.getFirstName(), "John", "First Name is not trimmed!");
        softAssert.assertEquals(edit.getLastName(), "Joe", "Last Name is not trimmed!");
        softAssert.assertEquals(edit.getEmail(), "johnjoe245@gmail.com", "Email is not trimmed!");
        softAssert.assertEquals(edit.getTelephone(), "0123456789", "Telephone is not trimmed!");

        // Collate all results and fail the test if any assertion failed
        softAssert.assertAll();
        
        logger.info("Test completed successfully");
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class RegisterPage extends BasePage {
	
	public RegisterPage(WebDriver driver) 
	{
        super(driver);
    }

    // Capturing Webelements
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By newsletterYes = By.xpath("//input[@name='newsletter' and @value='1']");
    private By newsletterNo = By.xpath("//input[@name='newsletter' and @value='0']");
    private By privacyPolicy = By.name("agree");
    private By continueButton = By.xpath("//input[@value='Continue']");
    
    // Field warnings
    private By firstNameWarning = By.xpath("//input[@id='input-firstname']/following-sibling::div");
    private By lastNameWarning = By.xpath("//input[@id='input-lastname']/following-sibling::div");
    private By emailWarning = By.xpath("//input[@id='input-email']/following-sibling::div");
    private By telephoneWarning = By.xpath("//input[@id='input-telephone']/following-sibling::div");
    private By passwordWarning = By.xpath("//input[@id='input-password']/following-sibling::div");

    // Top privacy warning
    private By privacyPolicyWarning = By.xpath("//div[contains(@class,'alert-danger')]");
    
    // Warning under Confirm Password
    private By confirmPasswordWarning =
            By.xpath("//input[@id='input-confirm']/following-sibling::div");

    // Top warning message
    private By existingEmailWarning =
            By.xpath("//div[contains(@class,'alert-danger')]");
    
    
    private By registerAccountPageHeading = By.xpath("//h1[normalize-space()='Register Account']");


    

    // Page Actions
    public void enterFirstName(String value) 
    { 
    	driver.findElement(firstName).sendKeys(value);
    }
   
   
    public void enterLastName(String value) 
    { 
      driver.findElement(lastName).sendKeys(value);
    }
    
    
    public void enterEmail(String value) 
    { 
    	driver.findElement(email).sendKeys(value); 
    }
    
    
    public void enterTelephone(String value) 
    { 
       driver.findElement(telephone).sendKeys(value);
    }
    
    
    public void enterPassword(String value) 
    { 
       driver.findElement(password).sendKeys(value);
    }
    
    
    public void enterConfirmPassword(String value)
    { 
    	driver.findElement(confirmPassword).sendKeys(value);  
    }
    
    public void subscribeNewsletterYes() 
    { 
    	driver.findElement(newsletterYes).click(); 
    }
    
    public void subscribeNewsletterNo() 
    { 
    	driver.findElement(newsletterNo).click(); 
    }
    
    public void acceptPrivacyPolicy() 
    { 
    	driver.findElement(privacyPolicy).click();
    }
    	    
    public void clickContinue() 
    
    { 
    	driver.findElement(continueButton).click(); 
    }
    
    // Business Methods
    public void registerWithMandatoryFields
   
    (String fName, String lName, String email,String phone, String pwd) 
    {

    	logger.info("Registering user with mandatory fields");
    	  
        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterTelephone(phone);
        enterPassword(pwd);
        enterConfirmPassword(pwd);
        acceptPrivacyPolicy();
        clickContinue();
    }
    
    public void registerWithAllFields
    
    (String fName, String lName, String email,String phone, String pwd) 
    {

    	logger.info("Registering user with all fields");
    	  
        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterTelephone(phone);
        enterPassword(pwd);
        enterConfirmPassword(pwd);
        subscribeNewsletterYes();
        acceptPrivacyPolicy();
        clickContinue();

    }
    
    public void submitEmptyRegistrationForm() {
        logger.info("Submitting empty registration form");
        clickContinue();
    }
    
    public void registerWithPasswordMismatch(
            String fName,
            String lName,
            String email,
            String phone,
            String pwd,
            String confirmPwd) {

        logger.info("Registering with mismatched passwords");

        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterTelephone(phone);
        subscribeNewsletterNo();
        acceptPrivacyPolicy();
        enterPassword(pwd);
        enterConfirmPassword(confirmPwd);
        clickContinue();
    }
    
    public void registerWithExistingEmail(
            String fName,
            String lName,
            String email,
            String phone,
            String pwd) {

        logger.info("Registering using existing email");

        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterTelephone(phone);
        enterPassword(pwd);
        enterConfirmPassword(pwd);
        subscribeNewsletterNo();
        acceptPrivacyPolicy();
        clickContinue();
    }
    
    public void registerWithInvalidEmail(
    		String fName,
            String lName,
            String invalidEmail,
            String phone,
            String pwd) {

    logger.info("Registering user with invalid email: {}", invalidEmail);

         enterFirstName(fName);
         enterLastName(lName);
         enterEmail(invalidEmail);
         enterTelephone(phone);
         enterPassword(pwd);
         enterConfirmPassword(pwd);
         subscribeNewsletterNo();
         acceptPrivacyPolicy();
         clickContinue();
     }
    
    
       public void registerWithInvalidPhoneNumber(
    		String fName,
            String lName,
            String email,
            String invalidPhone,
            String pwd) {

        logger.info("Registering user with phone: {}", invalidPhone);

           enterFirstName(fName);
           enterLastName(lName);
           enterEmail(email);
           enterTelephone(invalidPhone);
           enterPassword(pwd);
           enterConfirmPassword(pwd);
           subscribeNewsletterNo();
           acceptPrivacyPolicy();
           clickContinue();
  }
  
       
        // ====== Validation Methods ======

      
    public boolean isFirstNameWarningDisplayed() {
        String expected = "First Name must be between 1 and 32 characters!";
        return driver.findElement(firstNameWarning).isDisplayed() &&
               driver.findElement(firstNameWarning).getText().equals(expected);
    }

    public boolean isLastNameWarningDisplayed() {
        String expected = "Last Name must be between 1 and 32 characters!";
        return driver.findElement(lastNameWarning).isDisplayed() &&
               driver.findElement(lastNameWarning).getText().equals(expected);
    }

    public boolean isEmailWarningDisplayed() {
        String expected = "E-Mail Address does not appear to be valid!";
        return driver.findElement(emailWarning).isDisplayed() &&
               driver.findElement(emailWarning).getText().equals(expected);
    }

    public boolean isTelephoneWarningDisplayed() {
        String expected = "Telephone must be between 3 and 32 characters!";
        return driver.findElement(telephoneWarning).isDisplayed() &&
               driver.findElement(telephoneWarning).getText().equals(expected);
    }

    public boolean isPasswordWarningDisplayed() {
        String expected = "Password must be between 4 and 20 characters!";
        return driver.findElement(passwordWarning).isDisplayed() &&
               driver.findElement(passwordWarning).getText().equals(expected);
    }

    public boolean isPrivacyPolicyWarningDisplayed() {
        String expected = "Warning: You must agree to the Privacy Policy!";
        return driver.findElement(privacyPolicyWarning).isDisplayed() &&
               driver.findElement(privacyPolicyWarning).getText().contains(expected);
    }
    

    public boolean isPasswordMismatchWarningDisplayed() {
        String expected = "Password confirmation does not match password!";
        return driver.findElement(confirmPasswordWarning).isDisplayed() &&
                driver.findElement(confirmPasswordWarning).getText().equals(expected);
          }
    
   
    public boolean isExistingEmailWarningDisplayed() {

        String expected = "Warning: E-Mail Address is already registered!";
        return driver.findElement(existingEmailWarning).isDisplayed() && 
        	driver.findElement(existingEmailWarning).getText().contains(expected);
    }

    public String getPageHeading() {
    	logger.info("Getting Register Account Page Heading");
        return driver.findElement(registerAccountPageHeading).getText();
    }
    
}
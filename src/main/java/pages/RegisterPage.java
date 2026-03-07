package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
            By.xpath("//div[@class='text-danger']");

    // Top warning message
    private By existingEmailWarning =
            By.xpath("//div[contains(@class,'alert-danger')]");
    
    
    private By registerAccountPageHeading = By.xpath("//h1[normalize-space()='Register Account']");


    // Page Actions
    public void enterFirstName(String value) 
    { 
    	waitForVisibility(firstName);
    	driver.findElement(firstName).sendKeys(value);
    }
   
   
    public void enterLastName(String value) 
    { 
    	waitForVisibility(lastName);
      driver.findElement(lastName).sendKeys(value);
    }
    
    
    public void enterEmail(String value) 
    { 
    	waitForVisibility(email);
    	driver.findElement(email).sendKeys(value); 
    }
    
    
    public void enterTelephone(String value) 
    { 
    	waitForVisibility(telephone);
       driver.findElement(telephone).sendKeys(value);
    }
    
    
    public void enterPassword(String value) 
    { 
    	waitForVisibility(password);
       driver.findElement(password).sendKeys(value);
    }
    
    
    public void enterConfirmPassword(String value)
    { 
    	waitForVisibility(confirmPassword);
    	driver.findElement(confirmPassword).sendKeys(value);  
    }
    
    public void subscribeNewsletterYes() 
    { 
    	waitForElementToBeClickable(newsletterYes);
    	driver.findElement(newsletterYes).click(); 
    }
    
    public void subscribeNewsletterNo() 
    { 
    	waitForElementToBeClickable(newsletterNo);
    	driver.findElement(newsletterNo).click(); 
    }
    
    public void acceptPrivacyPolicy() 
    { 
    	waitForElementToBeClickable(privacyPolicy);
    	driver.findElement(privacyPolicy).click();
    }
    	    
    public void clickContinue() 
    
    { 
    	waitForElementToBeClickable(continueButton);
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
            String invalidPhoneNumber,
            String pwd) {

        logger.info("Registering user with invalid phone number: {}", invalidPhoneNumber);

           enterFirstName(fName);
           enterLastName(lName);
           enterEmail(email);
           enterTelephone(invalidPhoneNumber);
           enterPassword(pwd);
           enterConfirmPassword(pwd);
           subscribeNewsletterNo();
           acceptPrivacyPolicy();
           clickContinue();
  }
       

    public void registerUsingKeyboard(String fName, String lName, String email, String phone, String pwd) {
    	   
    	   waitForElementToBeClickable(firstName);

           // Focus on first field
           driver.findElement(firstName).click();
           driver.switchTo().activeElement().sendKeys(fName, Keys.TAB);

           driver.switchTo().activeElement().sendKeys(lName, Keys.TAB);
           driver.switchTo().activeElement().sendKeys(email, Keys.TAB);
           driver.switchTo().activeElement().sendKeys(phone, Keys.TAB);
           driver.switchTo().activeElement().sendKeys(pwd, Keys.TAB);
           driver.switchTo().activeElement().sendKeys(pwd, Keys.TAB);
           
           // Select NewsletterNo
          driver.switchTo().activeElement().sendKeys(Keys.TAB);
          driver.switchTo().activeElement().sendKeys(Keys.TAB);

           // Privacy Policy - Space to check
           driver.switchTo().activeElement().sendKeys(Keys.SPACE, Keys.TAB);

           // Press Enter on Continue
           driver.switchTo().activeElement().sendKeys(Keys.ENTER);

           logger.info("Registration submitted using keyboard keys");
       }

    
    public void registerWithSpaces(
    		String fName, String lName,
            String email, String phone,
            String pwd)
    	{
        logger.info("Registering user by entering spaces in all fields");

        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterTelephone(phone);
        enterPassword(pwd);
        enterConfirmPassword(pwd);
        subscribeNewsletterNo();
        acceptPrivacyPolicy();
        clickContinue();
        
        logger.info("Submitted registration form with spaces");
    }
  
  
    public void attemptRegistrationWithWeakPassword(
    		String fName,
            String lName,
            String email,
            String phone,
            String weakpwd) 
    {
        logger.info("Attempting registration using weak password: {}", weakpwd);

        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterTelephone(phone);
        enterPassword(weakpwd);
        enterConfirmPassword(weakpwd);
        subscribeNewsletterNo();
        acceptPrivacyPolicy();
        clickContinue();
        

        logger.info("Registration form submitted");
    }
    
    
    public void registerUserWithLeadingAndTrailingSpaces(String fName, String lName,
            String email, String phone,
            String pwd) {

    logger.info("Registering user with leading and trailing spaces");

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
    
    
       public void registerWithoutPrivacyPolicy(String fName, String lName,
            String email, String phone,
            String pwd) {

       logger.info("Registering user without selecting Privacy Policy");

             enterFirstName(fName);
             enterLastName(lName);
             enterEmail(email);
             enterTelephone(phone);
             enterPassword(pwd);
             enterConfirmPassword(pwd);
             subscribeNewsletterNo();
             clickContinue();
      }
       
       public void enterPasswordDetails(String pwd) {
           logger.info("Entering password into both fields");
           enterPassword(pwd);
           enterConfirmPassword(pwd);
       }
       
       
       public void registerWithoutPasswordConfirm(
               String fName,
               String lName,
               String email,
               String phone,
               String pwd) {

           logger.info("Executing business flow: Register without Password Confirm");

           enterFirstName(fName);
           enterLastName(lName);
           enterEmail(email);
           enterTelephone(phone);
           enterPassword(pwd);
           subscribeNewsletterNo();
           acceptPrivacyPolicy();
           clickContinue();
       }
       
        
       
        // ====== Validation Methods ======

      
    public boolean isFirstNameWarningDisplayed() {
    	waitForVisibility(firstNameWarning);
        String expected = "First Name must be between 1 and 32 characters!";
        WebElement firsnamewarn = driver.findElement(firstNameWarning);
        return firsnamewarn.isDisplayed() && firsnamewarn.getText().equals(expected);
    }

    public boolean isLastNameWarningDisplayed() {
    	waitForVisibility(lastNameWarning);
        String expected = "Last Name must be between 1 and 32 characters!";
        WebElement lastnamewarn = driver.findElement(lastNameWarning);
        return lastnamewarn.isDisplayed() && lastnamewarn.getText().equals(expected);
    }

    public boolean isEmailWarningDisplayed() {
    	waitForVisibility(emailWarning);
        String expected = "E-Mail Address does not appear to be valid!";
        WebElement emailwarn = driver.findElement(emailWarning);
        return emailwarn.isDisplayed() && emailwarn.getText().equals(expected);
    }

    public boolean isTelephoneWarningDisplayed() {
    	waitForVisibility(telephoneWarning);
        String expected = "Telephone must be between 3 and 32 characters!";
        WebElement phonewarn = driver.findElement(telephoneWarning);
        return phonewarn.isDisplayed() && phonewarn.getText().equals(expected);
    }

    public boolean isPasswordWarningDisplayed() {
    	waitForVisibility(passwordWarning);
        String expected = "Password must be between 4 and 20 characters!";
        WebElement passwordwarn = driver.findElement(passwordWarning);
        return passwordwarn.isDisplayed() && passwordwarn.getText().equals(expected);
    }

    public boolean isPrivacyPolicyWarningDisplayed() {
    	waitForVisibility(privacyPolicyWarning);
        String expected = "Warning: You must agree to the Privacy Policy!";
        WebElement privacywarn = driver.findElement(privacyPolicyWarning);
        return privacywarn.isDisplayed() && privacywarn.getText().equals(expected);
       
    }
    

    public boolean isPasswordMismatchWarningDisplayed() {
    	waitForVisibility(confirmPasswordWarning);
        String expected = "Password confirmation does not match password!";
        WebElement passwordmismatch = driver.findElement(confirmPasswordWarning);
        return passwordmismatch.isDisplayed() && passwordmismatch.getText().equals(expected);
          }
    
   
    public boolean isExistingEmailWarningDisplayed() {
    	waitForVisibility(existingEmailWarning);
        String expected = "Warning: E-Mail Address is already registered!";
        WebElement existingemail = driver.findElement(existingEmailWarning);
        return existingemail.isDisplayed() && existingemail.getText().contains(expected);
    }

    public String getPageHeading() {
    	logger.info("Getting Register Account Page Heading");
    	waitForVisibility(registerAccountPageHeading);
        return driver.findElement(registerAccountPageHeading).getText();
    }
    
    
    public String getPasswordFieldType() {
        logger.info("Fetching password field type attribute");
        return getAttribute(password, "type");
    }

    public String getConfirmPasswordFieldType() {
        logger.info("Fetching confirm password field type attribute");
        return getAttribute(confirmPassword, "type");
    }
    
    public boolean isPasswordHidden() {
        logger.info("Validating password fields are hidden");
        return "password".equalsIgnoreCase(getPasswordFieldType()) &&
               "password".equalsIgnoreCase(getConfirmPasswordFieldType());
    }
    
    public boolean isPasswordConfirmWarningDisplayed() {
        logger.info("Validating Password Confirm warning message is displayed");
        waitForVisibility(confirmPasswordWarning);
        String expected = "Password confirmation does not match password!";
        WebElement confirmpassword = driver.findElement(confirmPasswordWarning);
        return confirmpassword.isDisplayed() && confirmpassword.getText().equals(expected);
    }
    
    
}
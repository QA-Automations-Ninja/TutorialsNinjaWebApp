package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

     @DataProvider(name = "invalidEmails")
    public Object[][] invalidEmails() {
        return new Object[][]{
                {"automationninja82"},
                {"automationninja82@"},
                {"automationninja82@gmail"}
        };
    }
     
     
     
     @DataProvider(name = "invalidPhoneNumbers")
     public Object[][] invalidPhoneNumbers() {
         return new Object[][]{
                 {"1111"},
                 {"abcd"}
         };
     }
     
     
     
     @DataProvider(name = "weakPasswords")
     public Object[][] weakPasswords() {
         return new Object[][]{
                 {"123456"},
                 {"abcde"},
                 {"ABCDE"},
                 {"Efghij"},
                 {"Test1"},
                 {"Test@"}
         };
     }
     
     
     @DataProvider(name = "invalidLoginData")
     public Object[][] invalidLoginData() {

         return new Object[][] {

                 {"abc123@gmail.com", "Test123"},            // Invalid + Invalid
                 {"abc123@gmail.com", "Password123"},         // Invalid + Valid
                 {"automationninja82@gmail.com", "xyz123"},        // Valid + Invalid
                 {"", ""}                                        // Blank credentials
         };
     }
     
 }



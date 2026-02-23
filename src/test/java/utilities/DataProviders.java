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
 }



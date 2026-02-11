package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData", parallel = true)
    public Object[][] getLoginData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/resources/testdata/logintestdata.xlsx";
        ExcelUtility excel = new ExcelUtility(path);
        return excel.getData("Sheet1");
    }
}

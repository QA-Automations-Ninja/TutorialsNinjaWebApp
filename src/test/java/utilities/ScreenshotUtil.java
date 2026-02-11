package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    private WebDriver driver;

    // Constructor accepts WebDriver
    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }

    public String captureScreen(String tname) throws IOException {
        new File(System.getProperty("user.dir")+"\\screenshots\\").mkdirs();
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }
}

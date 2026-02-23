package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
    public static String captureScreen(WebDriver driver, String testName) throws IOException {

        // Screenshots directory
        String screenshotsDir = System.getProperty("user.dir") + File.separator + "screenshots";
        new File(screenshotsDir).mkdirs();

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String targetFilePath = screenshotsDir + File.separator + testName + "_" + timeStamp + ".png";

        Files.copy(sourceFile.toPath(), Paths.get(targetFilePath));

        return targetFilePath;
    }
}

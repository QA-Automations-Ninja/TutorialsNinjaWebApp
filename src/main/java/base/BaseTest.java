package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected Logger logger;

    protected WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browserFromXML) {

        logger = LogManager.getLogger(this.getClass());

        String browser = browserFromXML != null 
                ? browserFromXML 
                : ConfigReader.get("browser");

        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        logger.info("Starting test on browser: {} | Headless: {}", browser, headless);

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless=new");   //  headless mode
                    chromeOptions.addArguments("--disable-gpu"); // Windows require this
                    chromeOptions.addArguments("--window-size=1920,1080");   // avoid tiny window issues
                    chromeOptions.addArguments("--remote-allow-origins=*"); // avoids "connection refused"
                    chromeOptions.addArguments("--no-sandbox"); // safe for CI
                    chromeOptions.addArguments("--disable-dev-shm-usage");  // avoids shared memory issues

                }
                webDriver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("-headless");
                    firefoxOptions.addArguments("--width=1920");
                    firefoxOptions.addArguments("--height=1080");
                }
                webDriver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--disable-gpu");
                    edgeOptions.addArguments("--window-size=1920,1080");
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    edgeOptions.addArguments("--no-sandbox");
                    edgeOptions.addArguments("--disable-dev-shm-usage");
                }
                webDriver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }        driver.set(webDriver);

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(
                        Long.parseLong(ConfigReader.get("implicitWait"))));

        if (!headless) {
            getDriver().manage().window().maximize();
        }

        getDriver().get(ConfigReader.get("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}

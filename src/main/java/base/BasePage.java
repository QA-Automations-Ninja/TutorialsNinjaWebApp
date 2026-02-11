package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected final Logger logger;

    public BasePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException(
                "WebDriver is null. Make sure it is initialized in BaseTest before creating page objects."
            );
        }
        this.driver = driver;
        this.logger = LogManager.getLogger(this.getClass());
    }
}


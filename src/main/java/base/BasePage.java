package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected final Logger logger;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException(
                "WebDriver is null. Make sure it is initialized in BaseTest before creating page objects."
            );
        }
        this.driver = driver;
        this.logger = LogManager.getLogger(this.getClass());
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    protected void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    
    protected void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    
    
    protected String getAttribute(By locator, String attribute) {
    	 waitForVisibility(locator);
        return driver.findElement(locator).getAttribute(attribute);
    }
    
    
    
}


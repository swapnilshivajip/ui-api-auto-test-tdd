package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By throbber = By.id("loading-spinner"); // Throbber locator

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForThrobberToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait for the throbber to disappear
    public void waitForThrobberToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(throbber));
    }

    // Custom click method that includes waiting for the throbber
    public void clickWithWait(WebElement element) {
        element.click();  // Perform the click
        waitForThrobberToDisappear();  // Wait for the throbber to disappear after the click
    }
}


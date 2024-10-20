package base;

import config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.Utils;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static ThreadLocal<WebDriver> driverTL = new ThreadLocal<>();
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        System.out.println("Browser: "+browser);
        if (browser.equalsIgnoreCase("chrome")) {
            driverTL.set(driver = new ChromeDriver());
            driver = driverTL.get();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driverTL.set(driver = new FirefoxDriver());
            driver = driverTL.get();
        }
        baseUrl = ConfigLoader.getProperty(ConfigLoader.getProperty("env") + ".url");
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Setup Completed");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Utils.captureScreenshot(driver, result.getName());
        }
        driver.quit();
        System.out.println("Teardown Completed");
    }
}


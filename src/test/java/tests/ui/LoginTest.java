package tests.ui;

import base.BaseTest;
import config.ConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void testLoginWithDynamicWaits() {
        // Initialize the login page
        LoginPage loginPage = new LoginPage(driver);

        // Perform login action
        HomePage homePage = loginPage.login(ConfigLoader.getProperty("uname"), ConfigLoader.getProperty("pwd"));

        // Validate login success by asserting that the cart icon is displayed
        Assert.assertTrue(homePage.isShoppingCartDisplayed(), "Login failed, profile icon not found.");
        System.out.println("Test Completed");
        logger.info("Test Completed");
    }

    @Test
    public void dummyTest() {
        // Initialize the login page
        LoginPage loginPage = new LoginPage(driver);

        // Perform login action
        HomePage homePage = loginPage.login(ConfigLoader.getProperty("uname"), ConfigLoader.getProperty("pwd"));

        // Validate login success by asserting that the cart icon is displayed
        Assert.assertTrue(homePage.isShoppingCartDisplayed(), "Login failed, profile icon not found.");
        System.out.println("Test Completed");
        logger.info("Test Completed");
    }
}

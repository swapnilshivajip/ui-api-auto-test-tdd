package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ByDataTest;
import utils.WaitUtils;

public class HomePage {

    private WebDriver driver;
    private WaitUtils wait;
    private By shoppingCartIcon = ByDataTest.dataTestId("shopping-cart-link");
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(this.driver);
    }

    public boolean isShoppingCartDisplayed(){
        return driver.findElement(shoppingCartIcon).isDisplayed();
    }
}

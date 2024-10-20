package utils;

import org.openqa.selenium.By;

public class ByDataTest {

    // Custom locator method to find elements by "data-test" attribute
    public static By dataTestId(String dataTestValue) {
        return By.cssSelector("[data-test='" + dataTestValue + "']");
    }
}

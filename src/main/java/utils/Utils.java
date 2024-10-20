package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static void captureScreenshot(WebDriver driver, String testName) {
        // Get the screenshot as a file
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define screenshot path with a timestamp
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath = "screenshots/" + testName + "_" + timestamp + ".png";

        // Save the screenshot to the specified location
        try {
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ecommerce;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenshotTest extends BaseTest {

    @Test
    public void captureScreenshot() {
        try {
            // Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create folder if it doesn't exist
            String folderPath = "C:\\Users\\jius8\\OneDrive\\Desktop\\Screenshots";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Generate dynamic filename with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File dest = new File(folderPath + "\\screenshot_" + timestamp + ".png");

            // Save screenshot
            FileHandler.copy(src, dest);

            System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Failed to save screenshot: " + e.getMessage());
        }
    }
}

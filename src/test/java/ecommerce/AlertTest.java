package ecommerce;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void handleAlert() throws InterruptedException {
        // Navigate to local HTML file
        driver.get("file:///C:/Users/jius8/OneDrive/Desktop/alert.html");

        // Click button that triggers alert
        driver.findElement(By.id("alertButton")).click();

        // Switch to alert
        Alert alert = driver.switchTo().alert();

        // Keep alert visible for 2 seconds
        Thread.sleep(2000);

        // Capture alert text
        String alertText = alert.getText();

        // Accept the alert
        alert.accept();

        // Assertion: check alert text
        Assert.assertEquals(alertText, "This is a test alert!", "Unexpected alert message.");
    }
}

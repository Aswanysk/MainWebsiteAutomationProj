package ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSearchTest extends BaseTest {

    @Test
    public void searchProduct() {

        // Login
        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Go to Electronics category
        driver.get("https://shop.qaautomationlabs.com/electronics.php");

        // Locate the product search box
        By searchBox = By.cssSelector("[data-testid='search-input']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        // Search for Laptop
        driver.findElement(searchBox).sendKeys("Laptop");

        // Wait for the search/filter to take effect
        wait.until(driver -> {
            return driver.findElements(
                    By.cssSelector("[data-testid^='product-name-']")
            ).stream().anyMatch(element ->
                    element.isDisplayed() &&
                    element.getText().toLowerCase().contains("laptop")
            );
        });

        // Verify that a laptop product is displayed
        boolean laptopFound = driver.findElements(
                By.cssSelector("[data-testid^='product-name-']")
        ).stream().anyMatch(element ->
                element.isDisplayed() &&
                element.getText().toLowerCase().contains("laptop")
        );

        Assert.assertTrue(
                laptopFound,
                "Laptop product was not found after searching."
        );

        System.out.println("Product search successful.");
    }
}
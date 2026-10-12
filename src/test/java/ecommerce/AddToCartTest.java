package ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void addProductToCart() {

        // Login
        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open Electronics page
        driver.get("https://shop.qaautomationlabs.com/electronics.php");

        // Wait for LG UHD AI TV
        By lgTv = By.cssSelector("[data-testid='product-name-70']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lgTv));

        // Verify LG UHD AI TV is displayed
        Assert.assertTrue(
                driver.findElement(lgTv).isDisplayed(),
                "LG UHD AI TV is not displayed."
        );

        // Add LG UHD AI TV to cart
        By addToCart = By.cssSelector("[data-testid='add-to-cart-70']");

        wait.until(ExpectedConditions.elementToBeClickable(addToCart));

        driver.findElement(addToCart).click();

        System.out.println("LG UHD AI TV added to cart.");

        // Open Cart
        driver.get("https://shop.qaautomationlabs.com/cart.php");

        // Verify LG UHD AI TV is in the cart
        By cartProduct = By.xpath(
                "//*[contains(normalize-space(), 'LG UHD AI TV')]"
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartProduct)
        );

        Assert.assertTrue(
                driver.findElement(cartProduct).isDisplayed(),
                "LG UHD AI TV was not found in the cart."
        );

        System.out.println("LG UHD AI TV successfully verified in cart.");
    }
}
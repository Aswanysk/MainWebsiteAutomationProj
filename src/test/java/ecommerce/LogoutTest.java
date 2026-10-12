package ecommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutAfterLogin() {

        // Login first
        login();

        // Verify logged in
        Assert.assertTrue(
            driver.findElement(
                By.cssSelector("[data-testid='header-logout-btn']")
            ).isDisplayed(),
            "Login failed."
        );

        // Logout
        driver.findElement(
            By.cssSelector("[data-testid='header-logout-btn']")
        ).click();

        // Verify logged out
        Assert.assertTrue(
            driver.findElement(
                By.cssSelector("[data-testid='login-submit-btn']")
            ).isDisplayed(),
            "Logout failed."
        );
    }
}
package ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By email = By.cssSelector("[data-testid='login-email-input']");
        By password = By.cssSelector("[data-testid='login-password-input']");
        By loginButton = By.cssSelector("[data-testid='login-submit-btn']");
        By logoutButton = By.cssSelector("[data-testid='header-logout-btn']");

        System.out.println("1. Page loaded: " + driver.getCurrentUrl());

        // Enter email
        wait.until(ExpectedConditions.visibilityOfElementLocated(email))
                .sendKeys("demo@demo.com");

        // Verify email value
        wait.until(ExpectedConditions.attributeToBe(
                email, "value", "demo@demo.com"
        ));

        System.out.println("2. Email entered: "
                + driver.findElement(email).getAttribute("value"));

        // Enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
                .sendKeys("demo");

        // Verify password is not empty
        wait.until(driver ->
                !driver.findElement(password)
                        .getAttribute("value")
                        .isEmpty()
        );

        System.out.println("3. Password entered");

        // Click login
        wait.until(ExpectedConditions.elementToBeClickable(loginButton))
                .click();

        System.out.println("4. Login button clicked");

        // Wait for logout button
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

        System.out.println("5. Logout button found");

        Assert.assertTrue(
                driver.findElement(logoutButton).isDisplayed(),
                "Login failed - Logout button not found."
        );

        System.out.println("6. LOGIN SUCCESSFUL");
    }
}
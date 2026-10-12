package ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else {
            throw new IllegalArgumentException(
                "Browser not supported: " + browser
            );
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
            Duration.ofSeconds(15)
        );

        driver.get(
            "https://shop.qaautomationlabs.com/index.php"
        );
    }

    // Reusable login method
    protected void login() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(15));

        By email = By.cssSelector(
            "[data-testid='login-email-input']"
        );

        By password = By.cssSelector(
            "[data-testid='login-password-input']"
        );

        By loginButton = By.cssSelector(
            "[data-testid='login-submit-btn']"
        );

        By logoutButton = By.cssSelector(
            "[data-testid='header-logout-btn']"
        );

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(email)
        ).sendKeys("demo@demo.com");

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(password)
        ).sendKeys("demo");

        wait.until(
            ExpectedConditions.elementToBeClickable(loginButton)
        ).click();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(logoutButton)
        );
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
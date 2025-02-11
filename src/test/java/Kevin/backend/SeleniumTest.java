package Kevin.backend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Explicit wait
    }

    @Test
    public void testAddContact() {
        driver.get("http://localhost:3000/contacts");

        WebElement addContactButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Add New Contact')]")
                )
        );
        addContactButton.click();

        // Fill in details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")))
                .sendKeys("John Doe");
        driver.findElement(By.name("email")).sendKeys("john.doe@example.com");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("address")).sendKeys("123 Main Street");
        driver.findElement(By.name("title")).sendKeys("Software Engineer");
        driver.findElement(By.name("status")).sendKeys("Active");

        // Click Save and wait for staleness
        WebElement saveButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Save')]")
                )
        );
        saveButton.click();


        // Verify contact card
        WebElement contactCard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(., 'John Doe')]")
                )
        );
        assertTrue(contactCard.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

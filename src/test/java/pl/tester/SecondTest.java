package pl.tester;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SecondTest extends BaseTest{

    WebDriver driver;

    @Test
    public void firstTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist(By.cssSelector("p"));

        String tekstFromElement = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(tekstFromElement, "Dopiero się pojawiłem!");
        driver.quit();
    }

    @Test
    public void secondTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist(By.cssSelector("p"));

        String tekstFromElement = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(tekstFromElement, "Dopiero się pojawiłem!");
        driver.quit();
    }

    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element is on the page");
                return true;
            } else {
                System.out.println("Element isn't on the page");
                return false;
            }
        });
    }
}
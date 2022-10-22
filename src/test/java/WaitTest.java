import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitTest {

    WebDriver driver;

    @Test
    public void imageTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        //WebDriverWait
        /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("clickOnMe")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
        //Thread.sleep(5000);
        driver.findElement(By.tagName("p"));*/

        //FluentWait
        driver.findElement(By.id("clickOnMe")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(TimeoutException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(2));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("pp")));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("pa"))));
        //Thread.sleep(5000);
        //driver.findElement(By.tagName("p"));

        waitForElementToExist(By.cssSelector("p"));


    }

    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        /*wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> elements = driver.findElements(locator);
                if (elements.size() > 0) {
                    System.out.println("Element is on the page");
                    return true;
                } else {
                    System.out.println("Element isn't on the page");
                    return false;
                }
            }
        });*/

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
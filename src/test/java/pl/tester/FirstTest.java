package pl.tester;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

@Listeners(value = {SampleTestListener.class})
public class FirstTest extends BaseTest{
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void firstTest() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist(By.cssSelector("p"));

        WebElement para = driver.findElement(By.cssSelector("p"));

        //softAssert.assertEquals(para.isDisplayed(), true);
        //softAssert.assertTrue(para.isDisplayed());
        //softAssert.assertEquals(para.getText(), "Dopiero", "Teksty są różne");
        //softAssert.assertTrue(para.getText().startsWith("Dopiero"));
        //softAssert.assertFalse(para.getText().endsWith("Pojawiłem"));

        Assert.assertEquals(para.isDisplayed(), true);
        Assert.assertTrue(para.isDisplayed(), "Element is not display");
        Assert.assertEquals(para.getText(), "Dopiero", "Teksty są różne");
        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertFalse(para.getText().endsWith("Pojawiłem"));
        Assert.assertEquals(para.getText(), "Dopiero się pojawiłem!");

        driver.quit();
        //softAssert.assertAll();
    }

    @Ignore
    @Test
    public void secondTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist(By.cssSelector("p"));

        String tekstFromElement = driver.findElement(By.cssSelector("p")).getText();

        softAssert.assertEquals(tekstFromElement, "Dopiero się pojawiłem!");
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
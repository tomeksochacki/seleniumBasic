import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {

    @Test
    public void actionsTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");
        //WebElement inputField = driver.findElement(By.id("myFile"));

        Actions actions = new Actions(driver);
        actions.contextClick().perform();
        //actions.contextClick(inputField).perform();
        WebElement button = driver.findElement(By.xpath("//button[@id='bottom']"));
        //actions.doubleClick(button).perform();
        button.click();
        button.click();
    }
}

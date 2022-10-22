import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);

        //By firstName = By.name("fname");
        WebElement firstNameInput = driver.findElement(By.name("fname"));

        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);

        By input = By.tagName("input");
        WebElement inputLocator = driver.findElement(input);
        inputLocator.sendKeys("First");

        List<WebElement> inputs = driver.findElements(input);
        System.out.println(inputs.size());

        By linkText = By.linkText("Visit W3Schools.com!");
        WebElement linkW3School = driver.findElement(linkText);

        By partialLink = By.partialLinkText("Visit");
        WebElement linkW3School2 = driver.findElement(partialLink);

    }
}

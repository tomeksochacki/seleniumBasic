import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HomeWorkTest {

    @Test
    public void homeWorkTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement header = webDriver.findElement(By.tagName("h1"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(header).perform();
        WebElement headerAfterMoving = webDriver.findElement(By.tagName("h1"));

        /*System.out.println(header.getAttribute("background"));
        System.out.println(header.getAttribute("style"));
        System.out.println(header.getAttribute("background-color"));
        System.out.println(header.getCssValue("style"));
        System.out.println(header.getCssValue("color"));*/

        System.out.println(headerAfterMoving.getCssValue("background-color"));
        System.out.println(headerAfterMoving.getCssValue("color"));

        WebElement clickMeButton = webDriver.findElement(By.id("clickOnMe"));
        clickMeButton.click();

        Alert alert = webDriver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebElement label = webDriver.findElement(By.xpath("//label[@for='fname']"));
        System.out.println(label.getText());

        WebElement inputField = webDriver.findElement(By.cssSelector("#fname"));
        inputField.sendKeys("TraLaLa");
        System.out.println(inputField.getAttribute("value"));

        WebElement link = webDriver.findElement(By.linkText("Visit W3Schools.com!"));
        System.out.println(label.getText());
        link.click();
        webDriver.navigate().back();




    }
}

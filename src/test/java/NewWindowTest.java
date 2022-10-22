import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {

    @Test
    public void testNewWindow() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://testeroprogramowania.github.io/selenium");
        WebElement basicPageLink = webDriver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();

        webDriver.findElement(By.id("newPage")).click();
        String currentWindow = webDriver.getWindowHandle();
        Set<String> windowNames =  webDriver.getWindowHandles();
        for (String window: windowNames){
            if (!(window.equals(currentWindow))){
                webDriver.switchTo().window(window);
                System.out.println(window);
            }
        }
        //webDriver.switchTo().window();
        //webDriver.switchTo().frame(0);
        //WebElement acceptAllButton = webDriver.findElement(By.linkText("Zaakceptuj wszystko"));
        //acceptAllButton.click();
        //webDriver.findElement(By.name("q")).sendKeys("selenium");

        webDriver.switchTo().window(currentWindow);
        webDriver.findElement(By.name("fname")).sendKeys("Roman");
    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {

    @Test
    public void iframeTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        WebElement iframe = webDriver.findElement(By.xpath("//iframe[@src='basics.html']"));
        //webDriver.switchTo().frame(0);
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.id("fname")).sendKeys("Bartek");
        webDriver.switchTo().defaultContent();
        System.out.println(webDriver.findElement(By.tagName("h1")).getText());

    }
}

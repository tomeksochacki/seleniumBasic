import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void findElement() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By fullXpath = By.xpath("/html/body/div/ul");
        driver.findElement(fullXpath);

        By shortXpath = By.xpath("//div/ul");
        driver.findElement(shortXpath);

        By id = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(id);

        By name = By.xpath("//input[@name='fname']");
        driver.findElement(name);

        By para = By.xpath("//p[@class='topSecret']");
        driver.findElement(para);

        By input = By.xpath("//input");
        WebElement inputLocator = driver.findElement(input);
        inputLocator.sendKeys("First");
        List<WebElement> inputs = driver.findElements(input);
        System.out.println(inputs.size());

        By link = By.xpath("//a[text()='Visit W3Schools.com!']");
        driver.findElement(link);

        By partialText = By.xpath("//a[contains(text(),'Visit')]");
        driver.findElement(partialText);

        By allXpath = By.xpath("//*");
        driver.findElement(allXpath);

        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementWithAttribute = By.xpath("//*[@name]");
        driver.findElement(elementWithAttribute);

        By attributeStartName = By.xpath("//*[starts-with(@name, 'fname')]");
        driver.findElement(attributeStartName);
        //By attributeEndsName = By.xpath("//*[ends-with(@name, 'user')]");
        //driver.findElement(attributeEndsName);

        By attrEq = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(attrEq);
        By attrNotEq = By.xpath("//button[@id!='ClickOnMe']");
        driver.findElement(attrNotEq);
        By attrCont = By.xpath("//*[contains(@name,'fname')]");
        driver.findElement(attrCont);
        By attrStarts = By.xpath("//*[starts-with(@name, 'user')]");
        driver.findElement(attrStarts);
        By attrEnds = By.xpath("//*[substring(@name, string-length(@name)-string-length('name')+1) = 'name']");
        driver.findElement(attrEnds);

        By child = By.xpath("//div/child::ul");
        driver.findElement(child);
        By descendant = By.xpath("//div/descendant::ul");
        driver.findElement(descendant);
        By parent = By.xpath("//div/..");
        driver.findElement(parent);
        By ancestor = By.xpath("//div/ancestor::*");
        driver.findElement(ancestor);
        By following = By.xpath("//img/following::*");
        driver.findElement(following);
        By followingS = By.xpath("//div/following-sibling::*");
        driver.findElement(followingS);
        By prec = By.xpath("//div/preceding::*");
        driver.findElement(prec);
        By precS = By.xpath("//div/preceding-sibling::*");
        driver.findElement(precS);

    }
}

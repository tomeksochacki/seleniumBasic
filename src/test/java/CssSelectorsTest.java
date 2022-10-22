import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {

    @Test
    public void findElement() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");
        //# - zastępuje by id
        WebElement css = driver.findElement(cssId);

        By id = By.cssSelector(".topSecret");
        WebElement idSelector = driver.findElement(id);

        By tagName = By.cssSelector("input");
        WebElement tagSelector = driver.findElement(tagName);
        tagSelector.sendKeys("Second");

        By attributeName = By.cssSelector("[name = 'fname']");
        driver.findElement(attributeName);

        By cssClass = By.cssSelector("[class = 'topSecret']");
        driver.findElement(cssClass);

        By all = By.cssSelector("*");
        driver.findElements(all);

        By ulInsideDiv = By.cssSelector("div ul");
        driver.findElement(ulInsideDiv);

        By trInsideTable = By.cssSelector("table tr");
        driver.findElement(trInsideTable);

        By trInsideTbody = By.cssSelector("tbody tr");
        driver.findElement(trInsideTbody);

        By firstChildUlInDiv = By.cssSelector("div > ul");
        By firstChildTrInTbody = By.cssSelector("tbody > tr");

        driver.findElement(firstChildTrInTbody);
        driver.findElement(firstChildUlInDiv);

        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormsAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(firstFormAfterLabel);
        driver.findElement(allFormsAfterLabel);

        By attributeTag = By.cssSelector("input[name='fname']");
        By attributeContains = By.cssSelector("[name*='name']");
        By attributeStarts = By.cssSelector("[name^='f']");
        By attributeEnds = By.cssSelector("[name$='ame']");

        driver.findElement(attributeTag);
        driver.findElement(attributeContains);
        driver.findElement(attributeStarts);
        driver.findElement(attributeEnds);

        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By thirdChild = By.cssSelector("li:nth-child(3)");
        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(thirdChild);
    }
}

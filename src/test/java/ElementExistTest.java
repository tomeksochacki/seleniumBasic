import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExistTest {

    WebDriver driver;

    @Test
    public void elementExistTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        System.out.println("+++");
        System.out.println(elementExistSecond(By.tagName("p")));
        System.out.println(elementExistSecond(By.id("topSecret")));
        //driver.findElement(By.tagName("p"));
        //driver.findElement(By.id("topSecret"));

        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed());

        System.out.println("+");
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("checkkbox: " + checkbox.isSelected());
        checkbox.click();
        System.out.println("checkkbox: " + checkbox.isSelected());
    }

    public boolean elementExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception){
            return false;
        }
    }

    public boolean elementExistSecond(By locator){
        return driver.findElements(locator).size() > 0;
    }

}

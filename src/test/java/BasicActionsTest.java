import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {

    @Test
    public void performActions(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium");

        WebElement basicLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicLink.getText());
        basicLink.click();

        //driver.findElement(By.id("clickOnMe")).click();
        driver.findElement(By.name("fname")).sendKeys("Tomek");

        WebElement input = driver.findElement(By.name("username"));
        input.clear();
        input.sendKeys("Romek");
        System.out.println(input.getText());
        System.out.println(input.getAttribute("value"));
        input.sendKeys(Keys.ENTER);
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        Alert secoondAlert = driver.switchTo().alert();
        secoondAlert.accept();
        //input.sendKeys(Keys.TAB);
        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.clear();
        inputPassword.sendKeys("PasswordTomek");
        inputPassword.sendKeys(Keys.TAB);
       /* Alert secondAlert = driver.switchTo().alert();
        secondAlert.accept();
        driver.switchTo().alert().accept();*/
        //input.sendKeys(Keys.TAB);

        driver.findElement(By.cssSelector("[type='checkbox']")).click();

        driver.findElement(By.cssSelector("[value='male']")).click();

        WebElement carsSelect = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(carsSelect);
        //cars.selectByIndex(2);
        //cars.selectByVisibleText("Volvo");
        cars.selectByValue("saab");

        List<WebElement> options = cars.getOptions();
        for (WebElement element: options){
            System.out.println(element.getText());
        }

        SelectCheck selectCheck = new SelectCheck();
        System.out.println(selectCheck.checkOption("Nissan", carsSelect));

        WebElement paragraph = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println(paragraph.getText());
        System.out.println(paragraph.getAttribute("value"));
        System.out.println(paragraph.getAttribute("textContent"));

        //driver.switchTo().alert().accept();
    }
}

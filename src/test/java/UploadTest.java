import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadTest {

    @Test
    public void uploadFile() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        int randomNumber = ((int)Math.random()*1000);
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        WebElement inputField = driver.findElement(By.id("myFile"));
        //inputField.sendKeys("C:\\Users\\tomek\\Documents\\TestowanieAutomatyczne\\sample1.txt");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String fileName = "beforeUpload" + randomNumber + ".png";
        File beforefileScreen = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(beforefileScreen, new File("src/test/resources/" + fileName));
        inputField.sendKeys("C:\\Users\\tomek\\Documents\\TestowanieAutomatyczne\\sample.txt");

        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        actions.contextClick(inputField).perform();
    }
}

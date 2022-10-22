//metoda która przyjmuje String jako parametr i zwraca boolean
//sprawdza czy parametr String jest jedną z opcji w Select

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectCheck {

    public boolean checkOption(String value, WebElement element) {
        Select cars = new Select(element);
        List<WebElement> options = cars.getOptions();
        for (WebElement option : options) {
            if (value.equals(option.getText()))
                return true;
        }
        return false;
    }

    public boolean checkOptions(String value, WebElement element) {
        Select select = new Select(element);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement option: allOptions){
            if (value.equals(option.getText())){
                System.out.println(true);
                return true;
            }
        }
        return false;
    }
}

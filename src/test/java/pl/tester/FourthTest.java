package pl.tester;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FourthTest {

    @Test
    public void firstTest() {
        System.out.println("I'm first test method");
    }

    @Test
    public void secondTest() {
        System.out.println("I'm second test method");
    }

    @Test(dataProvider = "data")
    public void thirdTest(String val, Integer val2) {
        System.out.println(val + val2);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][]{{"1", 2}, {"2", 4}, {"3", 5}};
    }
}

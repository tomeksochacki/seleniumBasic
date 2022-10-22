package pl.tester;

import org.testng.annotations.Test;

public class ThirdTest {

    @Test (dependsOnMethods = "thirdTest")
    public void firstTest(){
        System.out.println("I'm first test");
    }

    @Test
    public void secondTest(){
        System.out.println("I'm second test");
    }

    @Test
    public void thirdTest(){
        System.out.println("I'm third test");
    }
}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestNgClass {
    WebDriver driver=new ChromeDriver();

    @Test(priority=0)
    public void login(){
        System.out.println("login");

        driver.get("https://www.facebook.com/");
        System.out.println("hello");

    }
    @Test(priority=1)
    public void register(){
        System.out.println("register");
    }
    @AfterClass
    public void closeBrowser(){
        System.out.println("closeBrowser");
        driver.quit();
    }
}

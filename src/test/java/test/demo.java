package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","D:\\selenium driver and jars\\chromedriver-win64\\chromedriver.exe");
        System.out.println("hello");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        System.out.println("hello");


    }
}

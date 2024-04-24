package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
    public static void main( String[] args ) throws InterruptedException
    {
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://placement.skcet.ac.in/login");
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id='email']")).sendKeys("727722euit033@skcet.ac.in"+Keys.ENTER);
       Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id='password']")).sendKeys("22it033,,"+Keys.ENTER);
       Thread.sleep(3000);
       
       
    }
    
}

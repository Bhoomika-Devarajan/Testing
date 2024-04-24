package com.example;

import org.openqa.selenium.By;
/**
 * Hello world!
 *
 */
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class cw1 
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        WebElement www1=driver.findElement(By.xpath("//*[@id='APjFqb']"));
        www1.sendKeys("selenium"+Keys.ENTER);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.firefox.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bing.com");
        
        
        
    }
}

package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
public class cw2 {

public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.shoppersstop.com");
        driver.findElement(By.id("profileImage")).sendKeys("shoppersstop"+Keys.ENTER);

        /*JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,250)"); */
        
    }
}

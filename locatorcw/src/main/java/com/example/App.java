package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://www.demoblaze.com/");
       
       WebElement gmailLink=driver.findElement(By.linkText("Laptops"));
       gmailLink.click();
       Thread.sleep(3000);
       WebElement web=driver.findElement(By.linkText("MacBook air"));
       web.click();
       Thread.sleep(3000);
       WebElement we=driver.findElement(By.linkText("Add to cart"));
       we.click();
       Thread.sleep(3000);
       //driver.switchTo().alert().getText();
       driver.switchTo().alert().accept();
       Thread.sleep(3000);
       WebElement to=driver.findElement(By.linkText("Cart"));
       to.click();
       Thread.sleep(3000);
       String tit=driver.findElement(By.xpath("//*[@id='tbodyid']/tr/td[2]")).getText();
       String pri=driver.findElement(By.xpath("//*[@id='tbodyid']/tr/td[3]")).getText();
       System.out.print(tit+" "+pri);


       

    }
}

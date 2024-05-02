
package com.example;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTestTwo 
{
    WebDriver driver;
    ExtentReports extent;
    ExtentTest logger;

    @BeforeTest
    public void setup()
    {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\Bhoomika Devarajan\\Desktop\\new.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

    }
    @Test
    public void testing() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
       // logger = extent.createTest("Test1","This is first Test");
        driver.get("https://www.moneycontrol.com");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/input[5]")).sendKeys("Reliance Industries");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"autosuggestlist\"]/ul/li[1]/a")).click();
        js.executeScript("window.scrollBy(0,900)");
        
        WebElement hoverable = driver.findElement(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]/a"));
        new Actions(driver).moveToElement(hoverable).perform();
        driver.findElement(By.linkText("SIP Return")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/div[2]/form/select")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/div[2]/form/select/option[3]")).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,9400)");
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/div[4]/form/select/option[2]")).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,9400)");
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[2]/input")).sendKeys("100000");
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[6]/div[2]/input")).sendKeys("2021-08-02");
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[6]/div[4]/input")).sendKeys("2023-08-17");
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input")).click();
        String period=driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[1]/td[1]")).getText();
        System.out.println("Investment Period");
    }
     @AfterMethod
    public void tearDown(ITestResult result)throws Exception
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            logger.log(Status.FAIL,"Testcase Failed : "+result.getName());
            logger.log(Status.FAIL,"Testcase Failed Reason: "+result.getThrowable());

            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String screenShotPath = "C:\\Users\\Bhoomika Devarajan\\Desktop\\new"+result.getName()+".png";
            FileUtils.copyFile(screenshot,new File(screenShotPath));
            logger.addScreenCaptureFromPath(screenShotPath);
        }
        else if(result.getStatus()==ITestResult.SUCCESS)
        {
            logger.log(Status.PASS,"Test Case Passed: "+result.getName());
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String screenShotPath = "C:\\Users\\Bhoomika Devarajan\\Desktop\\new"+result.getName()+".png";
            FileUtils.copyFile(screenshot,new File(screenShotPath));
            logger.addScreenCaptureFromPath(screenShotPath);
           
        }
        else if(result.getStatus()==ITestResult.SKIP)
        {
            logger.log(Status.SKIP,"Test Case Skipped: "+result.getName());
        }
        
    }

    @AfterTest
    public void afterTest()
    {
        extent.flush();
    }
}


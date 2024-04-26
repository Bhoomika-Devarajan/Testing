



package com.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class c2 {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest logger;

    @BeforeTest
    public void setup()
    {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\Bhoomika Devarajan\\Desktop\\Stesting1.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
    }

    @Test
    public void Test2() throws IOException, InterruptedException
    {
         logger = extent.createTest("Test2","This is Second Test");
         driver.get("https://www.ixigo.com/");
    }
    
    @Test
    public void Test1() throws IOException, InterruptedException
    {
        FileInputStream fs=new FileInputStream("C:\\Users\\Bhoomika Devarajan\\Desktop\\Report.xlsx"); 
        XSSFWorkbook workbook=new XSSFWorkbook(fs); 
         XSSFSheet sheet=workbook.getSheetAt(0); 
         Row row = sheet.getRow(0);
         String from = row.getCell(0).getStringCellValue();
         String to = row.getCell(1).getStringCellValue();
        logger = extent.createTest("Test1","This is First Test");
       
        driver.get("https://www.ixigo.com/");
         Thread.sleep(3000);
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[1]/div[1]/div/button[2]")).click();
         Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div")).click();
        
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/input")).sendKeys(from);
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/li")).click();;
         Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div")).click();
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/input")).sendKeys(to);
         Thread.sleep(1500);
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[1]/li")).click();
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div")).click();
         Thread.sleep(1500);
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div")).click();
         Thread.sleep(1500);
         
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[1]/button[2]")).click();
         Thread.sleep(1500);
         
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/button[11]")).click();
         Thread.sleep(1000);
         
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[11]")).click();
         Thread.sleep(1000);

         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[13]")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/button[2]")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div/button[3]")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[5]/div/div[3]")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/button")).click();
         Thread.sleep(1000);

         String ret = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div/div/p[2]")).getText();
    
         Assert.assertTrue(ret.contains("08 Nov"));
         
         
        }

    


    @AfterMethod
    public void tearDown(ITestResult result)throws Exception
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            logger.log(Status.FAIL,"Testcase Failed : "+result.getName());
            logger.log(Status.FAIL,"Testcase Failed Reason: "+result.getThrowable());

            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String screenShotPath = "C:\\Users\\DELL\\Desktop\\report\\"+result.getName()+".png";
            FileUtils.copyFile(screenshot,new File(screenShotPath));
            logger.addScreenCaptureFromPath(screenShotPath);
        }
        else if(result.getStatus()==ITestResult.SUCCESS)
        {
            logger.log(Status.PASS,"Test Case Passed: "+result.getName());
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String screenShotPath = "C:\\Users\\DELL\\Desktop\\report\\"+result.getName()+".png";
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
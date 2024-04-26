/*package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws InterruptedException 
     
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    { 
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys();
        driver.findElement(By.xpath("//*[@id='submit']")).click();




    }
}
*/
package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cw1 {

    @Test(dataProvider="one")
    public void test1(String username,String password)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
          String currentURL = driver.getCurrentUrl();
          String requiredString = "home";

          Assert.assertTrue(currentURL.contains(requiredString));
        }
        
        @Test(dataProvider="one")
        public void test2(String username,String password)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='deposit-menu-item']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id='selectedAccount']")).click();
        driver.findElement(By.xpath("//*[@id='selectedAccount']/option[3]")).click();
        driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("5000");
        driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement val = driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[3]/td[4]"));
        String data = val.getText();
        Assert.assertTrue(data.contains("5000"));
        
        
    }
        @Test(dataProvider="one")
        public void test3(String username,String password)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='withdraw-menu-item']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='selectedAccount']")).click();
        driver.findElement(By.xpath("//*[@id='selectedAccount']/option[3]")).click();
        driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("3000");
        driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement val = driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]"));
        String data = val.getText();
        Assert.assertTrue(data.contains("3000"));
        
        
    }


    @DataProvider(name ="one")
    public Object[][] fetchData() throws IOException
    {  FileInputStream fs=new FileInputStream("C:\\Users\\Bhoomika Devarajan\\Desktop\\testingng.xlsx");
        //create an workbook
        XSSFWorkbook workbook=new XSSFWorkbook(fs);
        XSSFSheet sheet=workbook.getSheetAt(0);
        int rowCount=sheet.getLastRowNum();
        int colCount=sheet.getRow(0).getLastCellNum();

        Object[][] data=new Object[rowCount][colCount];  
        for(int i=0;i<rowCount;i++)
        {  XSSFRow row=sheet.getRow(i+1); // to move to particular row from 1st row till last
            for(int j=0;j<colCount;j++)
            {  data[i][j]=row.getCell(j).getStringCellValue();
                System.out.print(data[i][j]+ " ");
            }
            System.out.println();
        }
        fs.close();
        return data;
    }


    }
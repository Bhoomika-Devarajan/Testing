package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
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

public class cw2 {

    @Test()
    public void test1() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.demoblaze.com");
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("MacBook air")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(3000); driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(3000);
        WebElement tit=driver.findElement(By.xpath("//*[@id='tbodyid']/tr/td[2]"));
        String newone=tit.getText();
        //System.out.print(tit);
        Assert.assertTrue(newone.contains("MacBook air"));
    }
    @Test(dataProvider="onee")
    public void testt2(String username,String password) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.demoblaze.com");
        driver.findElement(By.linkText("Log in")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='loginusername']")).sendKeys(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='loginpassword']")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();
        Thread.sleep(3000);
        String actual = driver.findElement(By.xpath("//*[@id='nameofuser']")).getText();
        String expected="Welcome Testalpha";
        Assert.assertTrue(actual.equals(expected));

    }
    @DataProvider(name ="onee")
    public Object[][] fetchData() throws IOException
    {  FileInputStream fs=new FileInputStream("C:\\Users\\Bhoomika Devarajan\\Desktop\\testingng.xlsx");
        //create an workbook
        XSSFWorkbook workbook=new XSSFWorkbook(fs);
        XSSFSheet sheet=workbook.getSheetAt(0);
        int rowCount=sheet.getLastRowNum();
        int colCount=sheet.getRow(0).getLastCellNum();

        Object[][] data=new Object[rowCount][colCount];  
        for(int i=0;i<rowCount;i++)
        {  Row row=sheet.getRow(i+1); // to move to particular row from 1st row till last
            for(int j=0;j<colCount;j++)
            {  data[i][j]=row.getCell(j).getStringCellValue();
                System.out.print(data[i][j]+ " ");
            }
            System.out.println();
        }
        workbook.close();
        fs.close();
        return data;
    }

}

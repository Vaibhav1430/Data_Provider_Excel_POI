package com.jbk;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivern {
	public WebDriver driver;
	@Test(dataProvider="TestData")
	  public void adminLogin(String uname, String pwd){
		System.setProperty("webdriver.crome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		 driver.get("http://www.gcrit.com/build3/admin/");
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 
		 driver.findElement(By.name("username")).sendKeys(uname);
		 driver.findElement(By.name("password")).sendKeys(pwd);
		 driver.findElement(By.id("tdb1")).click();
		 //Assert.assertEquals(driver.getCurrentUrl(), "http://www.gcrit.com/build3/admin/index.php");
		 String s = driver.getCurrentUrl();
		 System.out.println(s);
		 if(s.contains("http://www.gcrit.com/build3/admin/index.php")){
			 System.out.println("Login successfull");
		 }else
		 {
			 System.out.println("Login Unsccessfull");
		 }
	
	
	}
	
	@AfterMethod
	 public void closeBrowser(){
		driver.close();
	}
	
	
		@DataProvider(name="TestData")
		public Object [] [] readExcel() throws BiffException, IOException {
		File f = new File("C:\\Users\\Balag\\Desktop\\New Microsoft Office Excel Worksheet.xls");
		Workbook w = Workbook.getWorkbook(f);
		Sheet s = w.getSheet("Sheet1");
		
		int columns=s.getColumns();
		int rows=s.getRows();
		
		String inputData [] [] = new String[rows] [columns];
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				
				Cell c = s.getCell(j, i);
				inputData[i][j] = c.getContents();
				System.out.println(inputData[i][j]);
			}System.out.println();
		}
		return inputData;
		
		
}
}
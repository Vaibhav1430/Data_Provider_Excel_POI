package com.jbk;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class StringType_DataDriven_2DArray {
	
	public WebDriver driver;
	
	@Test(dataProvider="testData")
	public void adminLogin(String Username, String Password){
		
		driver = new FirefoxDriver();
		driver.get("http://www.gcrit.com/build3/admin/");
		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.id("tdb1")).click();
		Assert.assertEquals("http://www.gcrit.com/build3/admin/index.php", driver.getCurrentUrl());
		driver.close();
	}
	
	
	
	
	@DataProvider(name="testData")
	public Object[][] readExcel() throws BiffException, IOException  {
		
		File f = new File("E:\\J.B.K\\file1.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("pass");
		
		int colums=s.getColumns();
		int rows=s.getRows();
		
		String inputData [] [] = new String[rows] [colums];
		
		for(int i=0;i<rows;i++){
			
			for(int j=0;j<colums;j++){
				Cell c = s.getCell(j, i);
				inputData [i][j]=c.getContents();
			}
		}
		return inputData;
		
	}

}

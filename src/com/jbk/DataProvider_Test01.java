package com.jbk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.TestClass01;
import com.utility.Xls_Reader;

public class DataProvider_Test01 {

	WebDriver driver;
	@BeforeMethod
	
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("file:///E:/J.B.K/Selenium%20Software/Offline%20Website/pages/examples/users.html");
}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
	ArrayList<Object[]> testData = TestClass01.getDataFromExcel();
	return testData.iterator();
	}
	
	
	@Test(dataProvider="getTestData")
	public void offlineWebSiteTest(){
		
		//Enter Data
	//	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[1]")).clear();
		driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[1]")).getText();
		
		driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[2]")).getText();
		
		driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[3]")).getText();
		
		driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[4]")).getText();
		
		driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[5]")).getText();
		
		driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[6]")).getText();
		
		driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[7]")).getText();
				
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
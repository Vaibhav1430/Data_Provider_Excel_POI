package com.jbk;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class IntegerType_DataDrivern_2DArry {
	
	@Test(dataProvider="testData12")
	public void additions(String num1,String num2){
		
		
		int a=Integer.parseInt(num1);
		 int b=Integer.parseInt(num2);
		int result=a+b;

		System.out.println(result);
		//System.out.print(" ");
	}
	
	

	@DataProvider(name="testData12")
	public Object[][] readExcel() throws BiffException, IOException {
		
		File f = new File("‪C:\\Users\\Balag\\Desktop\\12.xls");
		Workbook w=Workbook.getWorkbook(f);
		Sheet s = w.getSheet("Sheet1");
		
		int colums=s.getColumns();
		int rows=s.getRows();
		
		String inputData [] [] = new String[rows] [colums];
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<colums;i++){
				Cell c = s.getCell(j, i);
				inputData [i][j]=c.getContents();
			}
		}
		return inputData;
	}
}

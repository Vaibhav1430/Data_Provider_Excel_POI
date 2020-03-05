package com.jbk;

import java.io.FileInputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Xl_Read {

	public static void main(String[] args) {
		try {
		//File f = new File("D:\\login.xls");
		FileInputStream fis = new FileInputStream("E:\\dataprovider.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("#");
		int rows = sh.getRows();
		int col = sh.getColumns();
		System.out.println(rows+" "+col);
		for(int i=0;i<=rows-1;i++) {
			
			for(int j=0;j<=col-1;j++) {
				Cell cell = sh.getCell(j, i);
				System.out.print(cell.getContents()+"  ");
			}
			System.out.println();
		}
		fis.close();
	        }catch(Exception e) {
		e.printStackTrace();
	      }
	}
}

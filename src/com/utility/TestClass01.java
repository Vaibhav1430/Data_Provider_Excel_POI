package com.utility;

import java.util.ArrayList;

public class TestClass01 {
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
			
			try{
				 reader = new Xls_Reader("E:\\dataprovider.xls");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			for(int rowNum=2; rowNum<=reader.getRowCount("Sheet1"); rowNum++){
				
				String No = reader.getCellData("Sheet1", "No", rowNum);
				String Username = reader.getCellData("Sheet1", "Username", rowNum);
				String Email = reader.getCellData("Sheet1", "Email", rowNum);
				String Mobile = reader.getCellData("Sheet1", "Mobile", rowNum);
				String Course = reader.getCellData("Sheet1", "Course", rowNum);
				String Gender = reader.getCellData("Sheet1", "Gender", rowNum);
				String State = reader.getCellData("Sheet1", "Username", rowNum);
				
				Object obj[] = {No, Username, Email, Mobile, Course, Gender, Username};
				myData.add(obj);
				
			
			}
			
		return myData;
		
	}
}

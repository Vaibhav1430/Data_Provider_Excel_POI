package xlsandxlsx;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Write_Xls {

 
	public static void main(String[] args) {
		WritableWorkbook  mywork=null;
	
		try{
			
	
		File file = new File("E:\\File.xls");
		
		 mywork = Workbook.createWorkbook(file);
		WritableSheet excelsheet = mywork.createSheet("Sheet1", 0);
		
		Label label = new Label(0, 0, "vaibhav");
		excelsheet.addCell(label);
		
		Number num = new Number(1, 0, 1);
		excelsheet.addCell(num);
		
		Label label1 = new Label(0, 1, "Ram");
		excelsheet.addCell(label1);
		
		Number num1 = new Number(1, 1, 3);
		excelsheet.addCell(num1);
		
		Label label3 = new Label(0, 2, "Sham");
		excelsheet.addCell(label3);
		
		Number num3 = new Number(1, 2, 10);
		excelsheet.addCell(num3);
		
//		Label label4 = new Label(1, 3, "jay");
//		excelsheet.addCell(label4);
//		
//		Number num4= new Number(1, 4, 100);
//		excelsheet.addCell(num4);
		
		mywork.write();
		//mywork.close();
			
		}catch (IOException e) {
			
			e.printStackTrace();
		}catch(WriteException e) {
			e.printStackTrace();
		}finally {
			if(mywork != null) {
				try {
					mywork.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
}
	}
}
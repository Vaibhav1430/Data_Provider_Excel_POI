package xlsandxlsx;

import java.io.FileInputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Read_Xls {

	public static void main(String[] args)  {
		try{
	
		FileInputStream fis = new FileInputStream("E:\\dataprovider.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rows = sh.getRows();
		int cols = sh.getColumns();
		System.out.println(rows + " "+cols);
		
		for(int i=0;i<=rows-1;i++){
			for(int j=0;j<=cols-1;j++){
				
				Cell cell = sh.getCell(j, i);
				System.out.print(cell.getContents()+ "    ");
			
			
			}System.out.println("    ");
		}
		
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	}
}
package testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelfunc {
	
	public static String excel_read(int row,int col) throws IOException {
		String file="C:\\Users\\amanp\\OneDrive\\Desktop\\eclipse-workspace\\Project3\\src\\test\\java\\testdata\\dataa.xlsx";
		String sheet="Sheet1";
		
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sh=wb.getSheet(sheet);
		String data= sh.getRow(row).getCell(col).getStringCellValue();
//		return data;
		
//		XSSFRow r=sh.getRow(0);
//		XSSFCell cell=r.getCell(0);
//		String data= cell.getStringCellValue();
		wb.close();
		return data;
		
		
		
	}
	

}

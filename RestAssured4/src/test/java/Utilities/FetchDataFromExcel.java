package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchDataFromExcel {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	FetchDataFromExcel(String excelpath,String sheetname) throws IOException
	 {
	  wb=new XSSFWorkbook(excelpath);
	  sheet=wb.getSheet(sheetname);
	 int x=sheet.getPhysicalNumberOfRows();
	 System.out.println(x);
	 }
		/*
		 * XSSFCell v=sheet.getRow(1).getCell(2);
		 *  XSSFCell v1=sheet.getRow(2).getCell(2); 
		 *  System.out.println(v);
		 *   System.out.println(v1);
		 */
	 public static Object getTestData(int rownum,int cellnum)
	 {
	 
	DataFormatter dm=new DataFormatter();
	String val=dm.formatCellValue(sheet.getRow(rownum).getCell(cellnum));
	return val;
	//System.out.println(val);
	 //"C:\\Users\\bhara\\OneDrive\\Documents\\TestData14thJan.xlsx"
	 }

}

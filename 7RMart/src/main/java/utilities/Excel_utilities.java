package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constants;

public class Excel_utilities {
	


	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh;

	public static String getStringdata(int a,int b,String sheet) throws IOException
	{   
		String filepath=Constants.TESTDATAFILE;
		f=new FileInputStream(filepath);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue();
		
	}
	public static String getIntegerdata(int a,int b,String sheet) throws IOException
	{   String filepath=Constants.TESTDATAFILE;
		f=new FileInputStream(filepath);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		int x=(int) c.getNumericCellValue();
		return String.valueOf(x);
		
	}


}

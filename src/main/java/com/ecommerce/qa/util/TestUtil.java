package com.ecommerce.qa.util;

import com.ecommerce.qa.base.TestBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class TestUtil extends TestBase {

	public TestUtil() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGELOAD_TIMEOUT=20;
	public static long IMPLICITWAIT=10;
	
	public static String TESTDATA_SHEETPATH="D:\\Anupama Work\\Anupama_work\\Automation_SelJava\\EcommerseWebsitePractice\\src\\main\\java\\com\\ecommerce\\qa\\testdata\\EcommerceTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	static XSSFWorkbook wb;
	XSSFSheet excelSheet;
	
	//Read Excel File Data : get complete data into object(Used with TestNG- DataProvider
	//read excel file- one dimensional only rows
	
	public static Object[] getTestData(String sheetName) {
		
		FileInputStream file=null;
		try {
				file=new FileInputStream(TESTDATA_SHEETPATH);
				System.out.println("File loaded successfully");
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		
		try {
			book=WorkbookFactory.create(file);
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		System.out.println("Got the sheet");
		
		Object[] data=new Object[sheet.getLastRowNum()];
		System.out.println("Number of rows in sheet :"+sheet.getLastRowNum());
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			data[i]=sheet.getRow(i+1).getCell(0).toString();
		}
		
		return data;		
		
	}
		
	//read excel file- two dimensional Rows and Columns
	public static Object[][] getTestData_RowColumn(String sheetName) {
			FileInputStream file=null;
			try {
				file=new FileInputStream(TESTDATA_SHEETPATH);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				book=WorkbookFactory.create(file);
			}catch(InvalidFormatException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			sheet=book.getSheet(sheetName);
			Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++){
				for(int j=0;j<sheet.getLastRowNum();j++)	{
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
			return data;		
			
	
}

	
	//Read Excel File Functions--------------------------------------------------------------------------
	//read data row by row
	
	 public static void readExcelFile() {
		 try {
			 File src=new File(TESTDATA_SHEETPATH);
			 FileInputStream fis=new FileInputStream(src);
			 wb=new XSSFWorkbook(fis);			 
		 }
		 catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 
	 public String getData(int sheetNum, int rrnum,int cnum) {
		 sheet=wb.getSheetAt(sheetNum);
		 String data=sheet.getRow(rrnum).getCell(cnum).getStringCellValue();
		 return data;
	 }
 
	 public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		}
	 	 
}
	
	
	
	
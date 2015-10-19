package com.bdd.framework.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/*
 * @author Hemanth.Sridhar
 */
public class ExcelLibrary {

	
	//xls
	static HSSFSheet hssfwrksheet;
	static HSSFWorkbook hssfwrkbook = null;
	
	//xlsx
	static XSSFSheet xssfwrksheet;
	static XSSFWorkbook xssfwrkbook =null;

	static Hashtable<String, Integer> hash= new Hashtable<String, Integer>();

	
	public ExcelLibrary(String ExcelSheetPath) throws IOException 
	{
			
		if(ExcelSheetPath.endsWith(".xls"))
		{//Initialize
		File file = new File(ExcelSheetPath);
		FileInputStream fis = new FileInputStream(file);
		hssfwrkbook = new HSSFWorkbook(fis);
		hssfwrksheet = hssfwrkbook.getSheet("Sheet1");
		int colNum = hssfwrksheet.getRow(0).getLastCellNum();
		hssfColumnDictionary(colNum);
	}
		else if(ExcelSheetPath.endsWith(".xlsx"))
		{
			File file = new File(ExcelSheetPath);
			FileInputStream fis = new FileInputStream(file);
			xssfwrkbook = new XSSFWorkbook(fis);
			xssfwrksheet = xssfwrkbook.getSheet("Sheet1");
			int colNum = xssfwrksheet.getRow(0).getLastCellNum();
			xssfColumnDictionary(colNum);
		}
		else
		{
			System.out.println("Format is invalid. The file format not supported by the custom library");
		}
	}
	
	public ExcelLibrary(String ExcelSheetPath, String sheet) throws IOException
	{
		//Initialize
		if(ExcelSheetPath.endsWith(".xls"))
		{
		File file = new File(ExcelSheetPath);
		FileInputStream fis = new FileInputStream(file);
		hssfwrkbook = new HSSFWorkbook(fis);
		hssfwrksheet = hssfwrkbook.getSheet("Sheet1");
		int colNum = hssfwrksheet.getRow(0).getLastCellNum();
		hssfColumnDictionary(colNum);
	}	
		else if(ExcelSheetPath.endsWith(".xlsx"))
		{
			File file = new File(ExcelSheetPath);
			FileInputStream fis = new FileInputStream(file);
			xssfwrkbook = new XSSFWorkbook(fis);
			xssfwrksheet = xssfwrkbook.getSheet("Sheet1");
			int colNum = xssfwrksheet.getRow(0).getLastCellNum();
			xssfColumnDictionary(colNum);
		}
		
		else
		{
			System.out.println("Format is invalid. The file format is not supported by the custom library");
		}
	}
	//Returns the Number of Rows for .xls
	public  int xlsRowCount()
	{
		int rowNum = hssfwrksheet.getLastRowNum()+1;
		return rowNum;
	}
	
	//Returns the number of rows for .xlsx
	public  int xlsxRowCount()
	{
		int rowNum = xssfwrksheet.getLastRowNum()+1;
		return rowNum;
	}
 
	//Returns the Cell value by taking row and Column values as argument
	//for .xls
	public  String xlsReadCell(int colNum,int rowNum)
	{
		String data[][] = new String[rowNum+1][colNum+1];
		HSSFRow row = hssfwrksheet.getRow(rowNum);
		HSSFCell cell = row.getCell(colNum); 
		String val = hssfcellToString(cell);
		data[rowNum][colNum] = val;
		if(val == null){
		System.out.println("data empty");	
		}
		return val;
		
	}
	
	//for .xlsx
	public  String xlsxReadCell(int colNum,int rowNum)
	{
		String data[][] = new String[rowNum+1][colNum+1];
		XSSFRow row = xssfwrksheet.getRow(rowNum);
		XSSFCell cell = row.getCell(colNum); 
		String val = xssfcellToString(cell);
		data[rowNum][colNum] = val;
		return val;
		
	}
	
	//for xls
	public String xlsReadCell(String colName, int rowNumber)
	{
		return xlsReadCell(GetCell(colName),rowNumber);
	}
	
	
	//for xlsx
	public  String xlsxReadCell(String colName, int rowNumber)
	{
		return xlsxReadCell(GetCell(colName),rowNumber);
	}
	
	
	//Create Column Dictionary to hold all the Column Names
	//for xls
	public void hssfColumnDictionary(int colNum)
	{
		
		//Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for(int col=0;col < colNum;col++)
		{
			hash.put(xlsReadCell(col,0), col);
		}
	}
	
	//for xlsx
	public void xssfColumnDictionary(int colNum)
	{
		
		//Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for(int col=0;col < colNum;col++)
		{
			hash.put(xlsxReadCell(col,0), col);
		}
	}
 
	//Read Column Names
	public static int GetCell(String colName)
	{
		try {
			int value;
			value =  ((Integer) hash.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);
 
		}
	}
	
	//for xls
	public static String hssfcellToString(HSSFCell cell){
		int type;
		Object result;
		type = cell.getCellType();
		
		switch(type){
		case 0: 
			result = cell.getNumericCellValue();
			break;
			
		case 1:
			result = cell.getStringCellValue();
			break;
			
		default:
			throw new RuntimeException("no support for this cell");
		}
		return result.toString();
	}
	
	//for xlsx
	public static String xssfcellToString(XSSFCell cell){
		int type;
		Object result;
		type = cell.getCellType();
		
		switch(type){
		case 0: 
			result = cell.getNumericCellValue();
			break;
			
		case 1:
			result = cell.getStringCellValue();
			break;
			
		default:
			throw new RuntimeException("no support for this cell");
		}
		return result.toString();
	}
}
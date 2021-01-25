package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;



public class ExcelFileData{
		    private static HSSFWorkbook workbook;
		    private static HSSFSheet sheet;
		    private static HSSFRow row;
		    private static HSSFCell cell;
		 
		   public static void setExcelFile(String excelFilePath,String sheetName) throws IOException {
		       //Create an object of File class to open xls file
		       File file =    new File(excelFilePath);
		       
		       //Create an object of FileInputStream class to read excel file
		       FileInputStream inputStream = new FileInputStream(file);
		       
		       //creating workbook instance that refers to .xls file
		       workbook=new HSSFWorkbook(inputStream);
		       
		       //creating a Sheet object
		        sheet=workbook.getSheet(sheetName);
		 
		   }
		 
		    public static String getCellData(int rowNumber,int cellNumber){
		       //getting the cell value from rowNumber and cell Number
		    	DataFormatter formatter=new DataFormatter();
		        cell =sheet.getRow(rowNumber).getCell(cellNumber);
		        String formatedCell=formatter.formatCellValue(cell);
		        return formatedCell;
		    }
		 
		    public static int getRowCountInSheet(){
		       int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		       return rowcount;
		    }
	
	
}

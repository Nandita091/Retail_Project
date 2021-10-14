package Util;


import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
 
public class ExcelApiTest
{
    public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
 
    public ExcelApiTest(String xlFilePath) throws Exception
    {
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }
    	
 // returns number of  rows in a sheet
    public int getRowCount(String sheetName)
    {
     int index = workbook.getSheetIndex(sheetName);
     if(index==-1)
      return 0;
     else
     {
     sheet = workbook.getSheetAt(index);
     int number=sheet.getLastRowNum()+1;
     return number;
     }
    
    }
    public int getColumnCount(String sheetName)
    {
     // check if sheet exists
     if(!isSheetExist(sheetName))
      return -1;
    
     sheet = workbook.getSheet(sheetName);
     row = sheet.getRow(0);
    
     if(row==null)
      return -1;
    
     return row.getLastCellNum();
    }
           // find whether sheets exists
    public boolean isSheetExist(String sheetName)
    {
     int index = workbook.getSheetIndex(sheetName);
     if(index==-1){
      index=workbook.getSheetIndex(sheetName.toUpperCase());
       if(index==-1)
        return false;
       else
        return true;
     }
     else
      return true;
    }
       
    public String getCellData(String sheetName,int colNum,int rowNum)
    {
    	String cellStringValue;
        try
        {
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            cell = row.getCell(colNum);
            cell.setCellType(CellType.STRING);
            return cell.getStringCellValue();
           // cellStringValue=cellconvertor(cell);
            }
        catch(Exception e)
        {
        //    e.printStackTrace();
       //     return "row "+rowNum+" or column "+colNum +" does not exist  in Excel";
        	cellStringValue=e.getMessage();
        }
        return cellStringValue;
    }
    public String cellconvertor(Cell cell)
    {
    	System.out.println(cell.getCellType());
        try {
        	
            String cellvalue=null;
            if(cell.getCellType().equals(CellType.STRING))
            {
                cellvalue= cell.getStringCellValue();
            }
            else if (cell.getCellType().equals(CellType.NUMERIC ))
            {

                if(HSSFDateUtil.isCellDateFormatted(cell))
                {
                    cellvalue=String.valueOf(cell.getDateCellValue());
                }
                else
                {
                    cellvalue= String.valueOf(cell.getNumericCellValue()); 
                    
                }       
            }
            return cellvalue;
        }

        catch(NullPointerException e)
        {
            throw new NullPointerException();
        }
    }
}

/*import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class ExcelApiTest
{
    public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
 
    public ExcelApiTest(String xlFilePath) throws Exception
    {
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }
    	
 // returns number of  rows in a sheet
    public int getRowCount(String sheetName)
    {
     int index = workbook.getSheetIndex(sheetName);
     if(index==-1)
      return 0;
     else
     {
     sheet = workbook.getSheetAt(index);
     int number=sheet.getLastRowNum()+1;
     return number;
     }
    
    }
    public int getColumnCount(String sheetName)
    {
     // check if sheet exists
     if(!isSheetExist(sheetName))
      return -1;
    
     sheet = workbook.getSheet(sheetName);
     row = sheet.getRow(0);
    
     if(row==null)
      return -1;
    
     return row.getLastCellNum();
    }
           // find whether sheets exists
    public boolean isSheetExist(String sheetName)
    {
     int index = workbook.getSheetIndex(sheetName);
     if(index==-1){
      index=workbook.getSheetIndex(sheetName.toUpperCase());
       if(index==-1)
        return false;
       else
        return true;
     }
     else
      return true;
    }
       
    public String getCellData(String sheetName,int colNum,int rowNum)
    {
        try
        {
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            cell = row.getCell(colNum);
                return cell.getStringCellValue();
            }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colNum +" does not exist  in Excel";
        }
    }
}*/
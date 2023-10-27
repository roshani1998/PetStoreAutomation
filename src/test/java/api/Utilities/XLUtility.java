package api.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLUtility 
{
	String path;
	
	public XLUtility(String path)
	{
		this.path="C:\\Users\\h\\eclipse-workspace\\PetStoreAutomation\\TestData\\ApiUserData.xlsx";
	}

	public int GetRowCount(String sheetName) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream file=new FileInputStream(path);
		
		int rowcount = WorkbookFactory.create(file).getSheet(sheetName).getLastRowNum();
		
		return rowcount;
	}
	
	public int GetCellCount(String sheetName, int rowNum) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream file=new FileInputStream(path);
		
        int cellCount = WorkbookFactory.create(file).getSheet(sheetName).getRow(rowNum).getLastCellNum();
		
        return cellCount;
	}
	
	public String GetCellData(String sheetName, int rownum, int colmnum) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream file=new FileInputStream(path);
		
		Cell cell = WorkbookFactory.create(file).getSheet(sheetName).getRow(rownum).getCell(colmnum);
		
		DataFormatter formatter= new DataFormatter();
		String data;
		
		try 
		{
			data= formatter.formatCellValue(cell);
		}
		catch (Exception e) 
		{
			data="";
		}
		
		return data;
		
	}
	
}

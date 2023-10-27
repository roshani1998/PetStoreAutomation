package api.Utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class DataProviders 
{

	@DataProvider(name="Data")
	public String[][] getAllData() throws EncryptedDocumentException, IOException 
	{
		String path = System.getProperty("C:\\Users\\h\\eclipse-workspace\\PetStoreAutomation")+"\\TestData\\ApiUserData.xlsx";
		XLUtility xl= new XLUtility(path);
		
		int rownum = xl.GetRowCount("Sheet1");
		int colcount = xl.GetCellCount("Sheet1", 1);
		
		String apidata[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				apidata[i-1][j] = xl.GetCellData("Sheet1", i, j);
			}
		}
		
		return apidata;
		
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws EncryptedDocumentException, IOException 
	{
		String path = System.getProperty("C:\\Users\\h\\eclipse-workspace\\PetStoreAutomation")+"\\TestData\\ApiUserData.xlsx";
		XLUtility xl= new XLUtility(path);
		
		int rownum = xl.GetRowCount("Sheet1");
		
		String apidata[]= new String[rownum];
		
		for(int i=1; i<=rownum; i++)
		{
			apidata[i-1]= xl.GetCellData("Sheet1", i, 1);
		}
		
		return apidata;
		
	}
	
	
	
}

package utilities;

import java.io.IOException;

public class DataProviders {

	// Data provider 1
	// provider name should be different from one DP to another DP,
	@org.testng.annotations.DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginData.xlsx"; // taking excel from testData
		
		// creating object for ExcelUtility
		// We need to pass path here, bcoz there is constructor in ExcelUtility class
		ExcelUtility xlUtil = new ExcelUtility(path);
		
		int totalRows = xlUtil.getRowCount("sheet1");
		int totalCols = xlUtil.getCellCount("sheet1", 1); // 1 is row number
		
		String logindata[][] = new String[totalRows][totalCols];
		
		// i=1 bcoz 0 index is heading so it starts from 1
		for(int i=1; i<=totalRows; i++) 
		{
			for(int j=0; j<totalCols; j++) // i is row and j is col
			{
				logindata[i-1][j] = xlUtil.getCell("sheet1", i, j);
				/*
				 i-1 bcoz i starts from 1 and index starts from 0, so we need to capture it from
				 suppose if we write log[i][j], in zero index it will empty in array[bcoz i=1]
				 so in order to avoid this log[i-1] =[1-1]= 0
				  
				 */
			}
		}
		return logindata;
	}
	
	
	// add data providers for other test cases, we will maintain all data providers in this class
}

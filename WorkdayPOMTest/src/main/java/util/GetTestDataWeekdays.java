package util;

import java.io.FileInputStream;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetTestDataWeekdays {
	public static HashMap<String,String> yes=new HashMap<String,String>();

	public static HashMap<String,String> no=new HashMap<String,String>();

	public void readWeekdays() throws Exception {
		// Open the Excel file
		FileInputStream inputStream = new FileInputStream(".\\Test Data\\WorkdayObjectSheet.xlsx");

		// Get the workbook from the input stream
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(1);

		int noOfRows= sheet.getPhysicalNumberOfRows();

		for(int row=1;row<=noOfRows;row++)
		{	
			String weekday=sheet.getRow(row).getCell(0).getStringCellValue();
			double hours=sheet.getRow(row).getCell(1).getNumericCellValue();	
			String condition=sheet.getRow(row).getCell(2).getStringCellValue();	


			String hr=String.valueOf(hours);         // Convert int in to string
			
			// Compare the condition to "Yes"
			if(condition.equalsIgnoreCase("Y")) {

				// If the condition is "Yes", add the weekday and hours to the "Yes" list
				yes.put(weekday,hr);				
			} 
			else if(condition.equalsIgnoreCase("N")) {
				// If the condition is "No", add the weekday and hours to the
				no.put(weekday,hr);
			}

			if(row==5)
				break;
		}
		workbook.close();
		inputStream.close();
	}

	public HashMap<String,String> GetTestDataWeekdays1() {
		// TODO Auto-generated method stub
		return yes;                                               // mon,thurs,fri
	}

	public HashMap<String,String> GetTestDataWeekdays2() {
		// TODO Auto-generated method stub
		return no;                                                 // tues ,wednes
	}

}

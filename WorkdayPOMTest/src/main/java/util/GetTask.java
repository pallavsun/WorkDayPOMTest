package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetTask {

	public static HashMap<String,String> Task=new HashMap<String,String>();

	public void readTask() throws IOException  {
		// Open the Excel file
		FileInputStream inputStream = new FileInputStream(".\\Test Data\\WorkdayObjectSheet.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(2);

		// Iterate through the rows of the sheet
		int noOfRows= sheet.getPhysicalNumberOfRows();       

		for(int row=1;row<=noOfRows;row++)
		{	
			String task=sheet.getRow(row).getCell(0).getStringCellValue();
			String condition=sheet.getRow(row).getCell(1).getStringCellValue();		

			// Compare the condition to "Yes"
			if (condition.equalsIgnoreCase("Y")) {

				// If the condition is "Yes", add the weekday and hours to the "Yes" list
				Task.put(task,condition);
			}

			if(row==6)
				break;
		}
		workbook.close();
	}
	public HashMap<String, String> getTaskmap() {
		// TODO Auto-generated method stub
		return Task;
	}
}

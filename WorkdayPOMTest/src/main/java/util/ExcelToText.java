package util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ExcelToText {

	public void Variables() throws IOException {
		// Open the Excel file
		FileInputStream fis = new FileInputStream(".\\Test Data\\WorkdayObjectSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int noOfRows= sheet.getPhysicalNumberOfRows();


		for(int row=2;row<=noOfRows;row++)
		{	
			String fileName=sheet.getRow(row).getCell(0).getStringCellValue();
			String data=sheet.getRow(row).getCell(1).getStringCellValue();		
			FileWriter fw = new FileWriter(".\\Variables\\"+fileName + ".txt");    // here variable is name of folder

			fw.write(data);
			fw.close();

			if(row==35)
				break;
		}
		workbook.close();
		fis.close();       
	}
}
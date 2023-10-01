package util;

import java.io.FileReader;
import java.io.IOException;

public class fetchXpath {
	public String fileRead(String fileName) {
		String content = "";

		try (FileReader reader = new FileReader(".\\Variables\\"+fileName + ".txt"))
		{
			int c;
			while ((c = reader.read()) != -1)
			{
				content += (char) c;
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return content;
	}
}
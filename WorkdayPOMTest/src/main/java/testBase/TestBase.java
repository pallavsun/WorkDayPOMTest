package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
    public static Properties prop;
    
   
    public TestBase(){
  		
  		try
  		{
  		  prop=new Properties();
  		  FileInputStream ip=new FileInputStream(".\\Test Data\\Environment.properties");
  		  prop.load(ip);
  		}
  		catch(FileNotFoundException e)
  		{
  			e.printStackTrace();
  		}
  		catch(IOException e)
  		{
  			e.printStackTrace();
  		}
  		
  	}
    

    public static void initalization() {
	
	String browserName=prop.getProperty("browser");
	if(browserName.endsWith("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}
	
	else if(browserName.endsWith("FF"))
	{
		WebDriverManager.chromedriver().setup();
		 driver=new FirefoxDriver();
	}
	
		
		
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	  driver.get(prop.getProperty("url"));	
		
	}
	
	
	
	
    
    
    
    
    
    
    
    
    
    
	
	
}

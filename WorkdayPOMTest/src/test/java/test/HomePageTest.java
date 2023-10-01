package test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testBase.TestBase;
import util.ExcelToText;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	ExcelToText a=new ExcelToText();

	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{

		initalization();
		a.Variables();
		loginPage=new LoginPage();	
		homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("pass"));
	}
	
	@Test(priority=1)
	public void homepagefunction() {
		
		homepage.home();
		
	}	
}

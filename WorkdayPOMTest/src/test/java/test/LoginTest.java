package test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testBase.TestBase;
import util.ExcelToText;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;
	ExcelToText a=new ExcelToText();

	public LoginTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException{

		initalization();
		a.Variables();
		loginPage=new LoginPage();	
	}

	@Test(priority=1)
	public void loginTest() throws InterruptedException 
	{
		homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("pass"));

	}
}
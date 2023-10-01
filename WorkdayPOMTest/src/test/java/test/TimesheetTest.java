package test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.TimeSheet;
import testBase.TestBase;
import util.ExcelToText;

public class TimesheetTest extends TestBase {


	LoginPage loginPage;
	HomePage homepage;
	TimeSheet timesheet;
	ExcelToText a=new ExcelToText();

	public TimesheetTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{

		initalization();
		a.Variables();
		loginPage=new LoginPage();	
		timesheet= new TimeSheet();
		homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("pass"));
		timesheet=homepage.home();
	}

	@Test(priority=1)
	public void timesheetfunctiontest() throws Exception {
		timesheet.WorkdayTimesheet();
	}
}

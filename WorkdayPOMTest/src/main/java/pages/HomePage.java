package pages;

import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;
import util.fetchXpath;

public class HomePage extends TestBase {

	Events e=new Events();
	fetchXpath f=new fetchXpath();
	void menu() {
		String globalNavigation=f.fileRead("WorkdayGlobalNavigation");
		int fl=0;
		fl=e.CheckForElementExixtence(globalNavigation);
		if(fl==1) {
			e.ClickButton(globalNavigation);
		}
	}

	void time() {
		String Time=f.fileRead("WorkdayTime");
		int fl=0;
		fl=e.CheckForElementExixtence(Time);
		if(fl==1) {
			e.ClickButton(Time);
		}
	}

	void thisWeek() {
		String ThisWeek=f.fileRead("WorkdayEnterTimeThisWeek");
		int fl=0;
		fl=e.CheckForElementExixtence(ThisWeek);
		if(fl==1) {
			e.ClickButton(ThisWeek);
		}
	}	

	public HomePage() {

		PageFactory.initElements(driver, this);

	}   

	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}

	public TimeSheet home()
	{

		menu();
		time();
		thisWeek();
		
		return new TimeSheet();

	}

}

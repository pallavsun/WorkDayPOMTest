package pages;

import java.util.HashMap;
import util.GetTestDataWeekdays;
import util.fetchXpath;
import testBase.TestBase;
import util.GetTask;

public class TimeSheet extends TestBase {

	Events e=new Events();
	fetchXpath f=new fetchXpath();
	GetTestDataWeekdays a=new GetTestDataWeekdays();
	GetTask b=new GetTask();
	HashMap<String,String> gt=a.GetTestDataWeekdays1();
	HashMap<String,String> lt=a.GetTestDataWeekdays2();
	HashMap<String,String> ts=b.getTaskmap();

	void GeneralTime(String task) throws InterruptedException {

		String search=f.fileRead("WorkdayEnterTimeByTypeSearch");       // returns the xpath
		SearchBar(search,"chr",task);
		
		if(ts.containsKey("Do Not Bill General")) {
			String dnbObjectGeneral=f.fileRead("WorkdayDnbCheckBox");
			checkbox(dnbObjectGeneral);
		}

		if(gt.containsKey("Monday")) {

			String Hour=gt.get("Monday");
			String monday=f.fileRead("WorkdayWeekdayMonday");
			EnterDays(monday,Hour);

		}

		if(gt.containsKey("Tuesday")) {

			String Hour=gt.get("Tuesday");
			String tuesday=f.fileRead("WorkdayWeekdayTuesday");
			EnterDays(tuesday,Hour);
		}

		if(gt.containsKey("Wednesday")) {

			String Hour=gt.get("Wednesday");
			String wednesday=f.fileRead("WorkdayWeekdayWednesday");
			EnterDays(wednesday,Hour);
		}

		if(gt.containsKey("Thursday")) {

			String Hour=gt.get("Thursday");
			String thursday=f.fileRead("WorkdayWeekdayThursday");
			EnterDays(thursday,Hour);
		}

		if(gt.containsKey("Friday")) {

			String Hour=gt.get("Friday");
			String friday=f.fileRead("WorkdayWeekdayFriday");
			EnterDays(friday,Hour);
		}
	}

	void LeaveTime(String task) throws InterruptedException {

		AddRow();

		String search=f.fileRead("WorkdayNewRowEnterTimeByTypeSearch");
		e.clickJAVASCRIPT(search);
		SearchBar(search,"chr",task);
		
		if(ts.containsKey("Do Not Bill Other")) {
			String dnbObjectOther=f.fileRead("WorkdayNewRowDnbCheckBox");
			checkbox(dnbObjectOther);
		}

		if(lt.containsKey("Monday")) {

			String Hour=lt.get("Monday");
			String monday=f.fileRead("WorkdayNewRowMonday");
			EnterDays(monday,Hour);

		}

		if(lt.containsKey("Tuesday")) {

			String Hour=lt.get("Tuesday");
			String tuesday=f.fileRead("WorkdayNewRowTuesday");
			EnterDays(tuesday,Hour);

		}

		if(lt.containsKey("Wednesday")) {

			String Hour=lt.get("Wednesday");
			String wednesday=f.fileRead("WorkdayNewRowWednesday");
			EnterDays(wednesday,Hour);

		}

		if(lt.containsKey("Thursday")) {

			String Hour=lt.get("Thursday");
			String thursday=f.fileRead("WorkdayNewRowThursday");
			EnterDays(thursday,Hour);

		}

		if(lt.containsKey("Friday")) {

			String Hour=lt.get("Friday");
			String friday=f.fileRead("WorkdayNewRowFriday");
			EnterDays(friday,Hour);

		}
	}

	public void taskSend() throws InterruptedException {

		if(ts.containsKey("General Idle Time")) {
			String task=f.fileRead("WorkdayProjectNameG&AIdleTime");
			GeneralTime(task);
		}
		if(ts.containsKey("Test Case Creation")) {
			String task=f.fileRead("WorkdayProjectNameTestCaseCreation");
			GeneralTime(task);
		}
		if(ts.containsKey("General Breaks")) {
			String task=f.fileRead("WorkdayProjectNameBreaks");
			GeneralTime(task);
		}

		if(ts.containsKey("General Leave")) {
			String task=f.fileRead("WorkdayNewRowProjectNameG&ALeave");
			LeaveTime(task);
		}

	}
	
	public void validateHour(int hour) {
		if(hour <=8 && hour !=0) {

		}
		else {

		}
	}

	public void validateTotalProjectedHours(int tHours) {
		if(tHours == 40) {

		}
		else {

		}
	}

//=========================================Methods=====================================	
	public void checkbox(String Value) {
		int fl=0;
		fl=e.CheckForElementExixtence(Value);
		if (fl==1) 
		{
			e.clickJAVASCRIPT(Value);
		}
	}

	public void SelectTask(String Value) throws InterruptedException {
		int fl=0;
		fl=e.CheckForElementExixtence(Value);
		if (fl==1) 
		{
			e.ScrollToViewElement(Value);
			e.clickJAVASCRIPT(Value);
			Thread.sleep(2000);
		}
	}

	public void EnterDays(String objectValue,String Hour) {
		int fl=0;
		fl=e.CheckForElementExixtence(objectValue);
		if(fl==1) {
			e.ClickandEnterData(objectValue, Hour);
			e.SendTab(objectValue);
		}
	}

	public void SearchBar(String objectValue,String projectName,String task) throws InterruptedException {
		int fl=0;
		fl=e.CheckForElementExixtence(objectValue);
		if(fl==1) {
			e.ClickandEnterData(objectValue, projectName);
			e.SendEnter(objectValue);
			SelectTask(task);
		}
	}

	public void AddRow() throws InterruptedException {
		String row=f.fileRead("WorkdayNewRowEnterTimeThisWeek");
		int fl=0;
		fl=e.CheckForElementExixtence(row);
		if (fl==1) 
		{
			e.ClickButton(row);
			Thread.sleep(2000);
		}
	}

	public void WorkdayTimesheet() throws Exception {

		a.readWeekdays();
		b.readTask();
		taskSend();
	}	
}

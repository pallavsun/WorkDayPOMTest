package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.TestBase;
import util.fetchXpath;

public class LoginPage extends TestBase{

	
	Events e=new Events();

	fetchXpath f=new fetchXpath();
	
	public void setUsername(String uname) {
		String username=f.fileRead("WorkdayUsername");
		int flag=0;
		flag=e.CheckForElementExixtence(username);
		if(flag==1) {
			e.ClickandEnterData(username,uname);
		}
	}

	public void setPassword(String pwd) {
		String password=f.fileRead("WorkdayPassword");
		int fl=0;
		fl=e.CheckForElementExixtence(password);
		if(fl==1) {
			e.ClickandEnterData(password,pwd);
		}
	}

	public void clickLoginButton() throws InterruptedException {
		String loginButton=f.fileRead("WorkdaySubmitButton");
		int fl=0;
		fl=e.CheckForElementExixtence(loginButton);
		if(fl==1) {
			e.ClickButton(loginButton);
		}
	}


	public LoginPage() {

		PageFactory.initElements(driver, this);

	}


	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public HomePage login(String un,String pwd) throws InterruptedException
	{
		setUsername(un);
		clickLoginButton();
		setPassword(pwd);
		clickLoginButton();
		
		return new HomePage();

	}


}

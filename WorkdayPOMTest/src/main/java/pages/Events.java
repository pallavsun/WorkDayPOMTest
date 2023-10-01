package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class Events extends TestBase{


	public Events() {

		PageFactory.initElements(driver, this);

	}

	//This method will check element is Displayed or not /Enabled or not
	int CheckForElementExixtence(String objectValue) {
		WebElement obv = driver.findElement(By.xpath(objectValue));
		int flag=0;
		if(obv.isDisplayed()) 
		{

			if(obv.isEnabled())
			{

				return flag=1; //if both conditions true then flag will return 1
			}
		}	
		else 
		{
			System.out.println("For "+objectValue+" Element Do not Exist");	
		}
		return flag; //if Element do not exist flag will return 0
	}

	//Click Button Method
	public void ClickButton(String objectValue) {
		driver.findElement(By.xpath(objectValue)).click();
	}

	//Click then Enter data
	public void ClickandEnterData(String objectValue, String data) {
		driver.findElement(By.xpath(objectValue)).click();
		driver.findElement(By.xpath(objectValue)).sendKeys(data);
	}

	//Clear then Enter data
	public void ClearandEnterData(String objectValue, String data) {
		driver.findElement(By.xpath(objectValue)).clear();
		driver.findElement(By.xpath(objectValue)).sendKeys(data);
	}

	//Press Enter by keyboard.
	public void SendEnter(String objectValue) {
		driver.findElement(By.xpath(objectValue)).sendKeys(Keys.ENTER);	
	}

	//Press Tab by keyboard.
	public void SendTab(String objectValue) {
		driver.findElement(By.xpath(objectValue)).sendKeys(Keys.TAB);	
	}

	//It will retrieve the value of element.
	public void GetText(String objectValue) {
		String a=driver.findElement(By.xpath(objectValue)).getText();
		System.out.println(a);
	}

	
	//It will scroll into the given element to make is visible in UI
	public  void ScrollToViewElement(String objectValue) throws InterruptedException {

		WebElement obj=driver.findElement(By.xpath(objectValue));
		// Javascript executor
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", obj);
		Thread.sleep(800);	
	}

	public void clickJAVASCRIPT(String objectValue) {

		WebElement obj=driver.findElement(By.xpath(objectValue));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",obj);  
	}
	
	
	
	
	
	
	}

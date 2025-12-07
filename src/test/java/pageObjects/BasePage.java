package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		/*
		 in POC package every class extends BasePage class, re-usability class
		 */
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // Constructor for HomePage
    public HomePage(WebDriver driver) {
        super(driver);  // Call the BasePage constructor
    }

    // Locators for MyAccount and Register (in menu bar)
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;
    
    @FindBy(xpath="//a[normalize-space()='Login']")
    WebElement lnkLogin;

    // Actions for the above elements
    public void clickMyAccount() {
        lnkMyAccount.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }
    
    public void clickLogin() {
    	lnkLogin.click();
    }
}
	
	
	


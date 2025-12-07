package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    // Constructor
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Locators for account registration fields and buttons
    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement txtFirstName;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txtLatName;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtemail;

    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtpwd;

    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement txtcpwd;

    @FindBy(xpath="//input[@name='agree']")
    WebElement chkpolicy;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement btncontinue;

    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgconfirmation;

    // Actions (methods) for interacting with the page elements
    public void setFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLatName.sendKeys(lname);
    }

    public void setEmail(String email) {
        txtemail.sendKeys(email);
    }

    public void setTelephone(String telNumber) {
        txtTelephone.sendKeys(telNumber);
    }

    public void setPassword(String pwd) {
        txtpwd.sendKeys(pwd);
    }

    public void setConfirmpassword(String cpwd) {
        txtcpwd.sendKeys(cpwd);
    }

    public void setPrivacyPolicy() {
        chkpolicy.click();
    }

    public void clickContinue() {
        btncontinue.click();
    }

    public String getConfirmationMessage() {
        try {
            return msgconfirmation.getText();
        } 
        
        catch (Exception e) {
            return e.getMessage();
        }
    }
}

	
	
	


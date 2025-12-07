package testCase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001AccountRegistrationTest extends BaseClass {

	
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration()
	{
		//info(charsequence message) select this info from AutoSuggestion
		logger.info("Starting Account RegistrationTest");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount");
		hp.clickRegister();
		logger.info("Clicked on Register");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("Providing Customer details......");
		regpage.setFirstName(randomString());
		regpage.setLastName(randomString());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphaNum();
		regpage.setPassword(password);
		regpage.setConfirmpassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected Message");
		String ConfirmMsg = regpage.getConfirmationMessage();
		if(ConfirmMsg.equals("Your Account Has Been Created!")) //"Your Account Has Been Created!
			{
			  Assert.assertTrue(true);
			}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(ConfirmMsg,"Your Account Has Been Created!");
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Finished Account RegistrationTest");
		
	}
	
	
	
	
	
	
}

package testCase;

import javax.security.auth.login.LoginContext;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002MyAccountTest extends BaseClass {

	@Test(groups={"Sanity", "Master"})
	public void verify_Login()
	{
		logger.info("*****Starting TC002_MyAccount Test*****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount");
		hp.clickLogin();
		logger.info("Clicked on Login");
		
		LoginPage lp = new LoginPage(driver);
		/*
		 eventhough email and password are variables, we need to keep them in double quote
		 because we accessing them from property file not from java file
		 */
		logger.info("Providing user credentials");
		lp.setEmailAddress(p.getProperty("email")); // p.getProperty("email")
		lp.setPassword(p.getProperty("password"));  // p.getProperty("password")
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		
		logger.info("Validating MyAccount Heading");
		boolean HeadingDisplay = macc.isMyAccountExist();
		
		Assert.assertTrue(HeadingDisplay);
		// Assert.assertEquals(HeadingDisplay, true, "Login fails");
		/*
		 here we are passing 3 arguments, it means, starting two arguments it will compare
		 if it fails then Login fails statement will execute
		 */
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****Testing Finished******");
	}
	
	
	
}

package testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriven")
	public void verify_Login(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("*******Starting TC003_LoginDDT********");
	
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmailAddress(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean msgHeading = macc.isMyAccountExist();
		
 /*     Data is valid > login successful > test pass > Logout
                valid > login unsuccessful> test failed
                
        Data is invalid > login successful > test failed > logout
                invalid > login unsuccessful > test passed         
 */
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(msgHeading==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(msgHeading==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(2000);
		logger.info("*******Finished TC003_LoginDDT********");
	}

	
	
}

package testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Testbase;
import pages.Loginpage;
import utility.CaptureScreenshot;

public class LoginwithmultipleCredentlas extends Testbase

{

	Loginpage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new Loginpage();
	}
	@DataProvider(name="Credentials")
	public Object[] [] getData()
	{
		return new Object [] []
				{
						{"standard_user","secret_sauce"},
						{"locked_out_user","secret_sauce"},
						{"problem_user","secret_sauce"},
						{"performance_glitch_user","secret_sauce"},
						{"error_user","secret_sauce"},
						{"visual_user","secret_sauce"},
						/*{"standard_user","secret_sauce"},
						{"standard_user1","secret_sauce"},
						{"standard_user","secret_sauce1"},
						{"standard_user1","secret_sauce1"},*/
						
				};
	}
	@Test (dataProvider = "Credentials")
	public void logintoappwithmulticredsTest (String un, String pass)
	{
		SoftAssert s= new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.logintoappwithmulticreds(un, pass);
		s.assertEquals(expURL, actURL);
		s.assertAll();
	}
	@AfterMethod
	public void closeBroweser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.ScreenShot(it.getName());
		}
		driver.close();
	}
}

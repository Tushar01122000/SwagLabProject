package testcases;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.Loginpage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class LoginpageTest extends Testbase
{
	Loginpage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new Loginpage();
	}
	@Test(groups = "sanity")
	public void verifyTitleofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 0);//0R,0C
		String actTitle=login.verifyTitleofApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test(groups = "sanity")
	public void verifyURLofApplication() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 1);//0R,1C
		String actURL=login.verifyURLofApplication();
		Assert.assertEquals(actURL, actURL);
	}
	@Test(groups = "retesting")
	public void loginToApplication() throws IOException
	{
		String expURL=ReadData.readExcel(0, 2);//0R,2C
		
		String actURL=login.loginToApplication();
		Assert.assertEquals(actURL, actURL);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBroweser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.ScreenShot(it.getName());
		}
		report.flush();
		driver.close();
	}
	
}

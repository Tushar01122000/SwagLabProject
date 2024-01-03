package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.Inventory_page2;
import pages.Loginpage;
import utility.ReadData;

public class Inventory_page_2test extends Testbase
{	
	Loginpage login;
	Inventory_page2 invent;
	
	@BeforeMethod(alwaysRun = true)
	
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new Loginpage();
		invent=new Inventory_page2();
		login.loginToApplication();
	}
	@Test(groups = "sanity")
	public void verifyproductlableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel(0, 3);//0R,3C
		String actLable=invent.verifyproductlable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Label of inventory page ="+ actLable);
	}
	@Test (groups = "sanity")
	public void veriftyLogoTest()
	{
		boolean result=invent.veriftyLogo();
		Assert.assertEquals(result, true);
		Reporter.log("visibility of facebook logo = " + result);
		boolean result1=invent.veriftyLogo();
		Assert.assertEquals(result1, true);
		Reporter.log("visibility of linkedin logo = " + result1);
		boolean result2=invent.veriftyLogo();
		Assert.assertEquals(result2, true);
		Reporter.log("visibility oof app logo"+ result2);
		boolean result3=invent.veriftyLogo();
		Assert.assertEquals(result3, true);
		Reporter.log("visibility of twitter logo "+ result3);
	}
	@Test(groups = "sanity")
	public void add6productsTest() throws EncryptedDocumentException, IOException
	{
		
		String expCount=ReadData.readExcel(0, 4);//0R,4C
		String actCount=invent.add6products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("total products added to cart "+ actCount);
	}
	@Test(groups = "retesting")
	public void verityfooterLinkTest()
	{
		String explinkText="© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actlinkText=invent.verityfooterLink();
		Assert.assertEquals(explinkText, actlinkText);
		Reporter.log("text of footer link"+actlinkText);
	}
	@Test(groups = "retesting")
	public void remove2ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 5);//0R,5C
		String actCount=invent.remove2Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("count of product after removing = " + actCount);
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBroweser()
	{
		driver.close();
	}
	
}

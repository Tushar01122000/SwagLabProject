package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.Cart_page;
import pages.Checkout_Page2;
import pages.Checkout_page1;
import pages.Inventory_page2;
import pages.Loginpage;
import utility.CaptureScreenshot;

public class Checkout_Page2_Test extends Testbase
{
	Loginpage login;
	Inventory_page2 invent;
	Cart_page Cart;
	Checkout_page1 check1;
	Checkout_Page2 check2;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new Loginpage();
		invent=new Inventory_page2();
		login.loginToApplication();
		invent.add6products();
		check1= new Checkout_page1();
		check2=new Checkout_Page2();
		Cart = new Cart_page();
		Cart.VerifyshoppingCartPage();
		Cart.verifycontinuebutton();
		Cart.verifycheckoutbutton();
		Cart.clickCheckoutbutton();
		check1.inputinformation();
		
		
		
	}
	@Test
	public void VerifyCheckoutpage2TextTest()
	{
		String exptext="Checkout: Overview";
		String acttext= check1.Verifycheckoutpagetext();
		Assert.assertEquals(exptext, acttext);
		Reporter.log("checkout page text label= "+acttext); 
	}
	@Test
	public void verifyClickonfinishbtnTest()
	
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=check2.verifyClickonfinishbtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("url of the finish page= "+actURL);
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

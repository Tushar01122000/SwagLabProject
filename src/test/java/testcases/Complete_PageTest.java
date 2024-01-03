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
import pages.complete_page;
import utility.CaptureScreenshot;

public class Complete_PageTest extends Testbase
{

	Loginpage login;
	Inventory_page2 invent;
	Cart_page Cart;
	Checkout_page1 check1;
	Checkout_Page2 check2;
	complete_page comp;
	
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
		check2.verifyClickonfinishbtn();
		comp= new complete_page();
		
		
		
		
	}
	@Test(enabled=true,priority =1)
	public void VerifyURLofcompletepageTest()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=comp.VerifyURLofcompletepage();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("url of complete page= "+actURL);
	}
	@Test(enabled =true ,priority =2)
	public void VerifycompletepagetxtlableTest()
	{
		String exptext="Checkout: Complete!";
		String acttext=comp.Verifycompletepagetxtlable();
		Assert.assertEquals(exptext, acttext);
		Reporter.log("complete page text= "+acttext);
	}
	@Test(enabled=true,priority=3)
	public void VerifyDisplayimageTest()
	{
		boolean logo = comp.VerifyDisplayimage();
		Assert.assertEquals(logo, true);
		Reporter.log("display of image complete page:- "+logo);
	}
	@Test
	public void VerifyThankyouTextTest()
	{
		String exptext2="Thank you for your order!";
		String acttext2=comp.VerifyThankyouText();
		Assert.assertEquals(exptext2, acttext2);
		Reporter.log("Thank you text = "+acttext2);
	}
	@Test
	public void VerifycompletetextTest()
	{
		String exptext3="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String acttext3=comp.Verifycompletetext();
		Assert.assertEquals(exptext3, acttext3);
		Reporter.log("long complete test ="+acttext3);
	}
	@Test
	public void VerifybackhomebtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=comp.Verifybackhomebtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("url after clicking on back home button = "+actURL);
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

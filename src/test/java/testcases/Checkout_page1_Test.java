package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.Cart_page;
import pages.Checkout_page1;
import pages.Inventory_page2;
import pages.Loginpage;
import utility.CaptureScreenshot;

public class Checkout_page1_Test extends Testbase
{
	
	Loginpage login;
	Inventory_page2 invent;
	Cart_page Cart;
	Checkout_page1 check1;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new Loginpage();
		invent=new Inventory_page2();
		login.loginToApplication();
		invent.add6products();
		check1= new Checkout_page1();
		Cart = new Cart_page();
		Cart.VerifyshoppingCartPage();
		Cart.verifycontinuebutton();
		Cart.verifycheckoutbutton();
		Cart.clickCheckoutbutton();
		
	}
	
	@Test
	public void VerifyURLofcheckoutpage1Test()
	{
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL=check1.VerifyURLofcheckoutpage1();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("title oof chechk out page 1 = "+actURL);
	}
	@Test
	public void verifyVerifycheckoutpagetexTtest()
	{
		String expURL="Checkout: Your Information";
		String actURL=check1.Verifycheckoutpagetext();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("text on the checkout page = "+actURL);
	}
	@Test
	public void inputinformationTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check1.inputinformation();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("title of checkout page 2= "+actURL);
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

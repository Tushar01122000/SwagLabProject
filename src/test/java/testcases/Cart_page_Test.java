package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.Cart_page;
import pages.Inventory_page2;
import pages.Loginpage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class Cart_page_Test extends Testbase
{
	Loginpage login;
	Inventory_page2 invent;
	Cart_page Cart;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new Loginpage();
		invent=new Inventory_page2();
		login.loginToApplication();
		invent.add6products();
		Cart = new Cart_page();
		Cart.VerifyshoppingCartPage();
	}
	@Test
	public void VerifyshoppingCartPageTest()
	{
		boolean cart= Cart.VerifyshoppingCartPage();
		Assert.assertEquals(cart, true);
		Reporter.log("shopping cart of inventory page:- "+cart);
		
	}
	@Test
	public void VerifyURLofCartPageTest() throws EncryptedDocumentException, IOException
	{
		String expURL="https://www.saucedemo.com/cart.html"; //ReadData.readExcel(1, 2)
		String actURL=Cart.VerifyURLofCartPage();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("url of your cart="+actURL);
	}
	@Test
	public void verifyCartTitleTest()
	{
		String expTitle="Your Cart";
		String actTitle=Cart.verifyCartTitle();
		
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("title of your cart:-="+actTitle);
		
	}
	@Test
	public void verifydescriptiontest()
	{
		String explabel="Description";
		String actlabel=Cart.verifydescriptiontext();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log("visibility of cart page description label= "+actlabel);
	}
	@Test
	public void verifycheckoutbuttonTest()
	{
		String expBtn="Checkout";
		String actBtn=Cart.verifycheckoutbutton();
		Assert.assertEquals(expBtn, actBtn);
		Reporter.log("checkout button of cart page="+actBtn);
		
	}
	@Test
	public void verifyURLofCheckOutPageTest()
	{
		String expurl="https//www.saucedemo.com";
		String acturl=Cart.verifyURLofCheckOutPage();
		Assert.assertEquals(acturl, acturl);
		Reporter.log("url of checkout pagetest="+acturl);
	}
	@Test
	public void verifycartTwitterlogo()
	{
		boolean twitter= Cart.verifycartTwitterlogo();
		Assert.assertEquals(twitter, true);
		Reporter.log("twitter log of cart page="+twitter);
	}
	@Test
	public void verifyfacebooklogo()
	{
		boolean facebook=Cart.verifyfacebooklogo();
		Assert.assertEquals(facebook, true);
		Reporter.log("facebook logo of cart page="+facebook);
	}

	@Test
	public void verifylinkdinlogo()
	{
		boolean linkdin= Cart.verifylinkdinlogo();
		Assert.assertEquals(linkdin, true);
		Reporter.log("linkdin logo cart page="+linkdin);
	}
	@Test 
	public void verifythreedoticon()
	{
		boolean lines= Cart.verifythreedoticon();
		Assert.assertEquals(lines, true);
		Reporter.log("visibility of cart page open menu three dot lines"+lines);
	}
	@Test
	public void verifyfootertext()
	{
		boolean footer= Cart.verifyfootertext();
		Assert.assertEquals(footer, true);
		Reporter.log("footer line text cart page="+footer);
	}
	@Test
	public void remove3productsCartPage() throws InterruptedException
	{
		String exp="3";
		String act= Cart.remove3productsCartPage();
		Assert.assertEquals(act, exp);
		Reporter.log("remove 3 products of cart page="+act);
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

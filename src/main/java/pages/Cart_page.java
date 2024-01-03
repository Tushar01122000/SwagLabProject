package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Cart_page extends Testbase

{
	//object Repository
	//logo
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterImagelogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebooklogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkdinlogo;
	//remove products
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement removeproduct1;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeproduct2;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removeproduct3;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement removeproduct4;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']")private WebElement removeproduct5;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")private WebElement removeproduct6;
	//remaining elements
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkoutbutton;
	@FindBy(xpath = "//button[@id='continue-shopping']") private WebElement continuebutton;
	@FindBy(xpath = "//div[@class='footer_copy']")private WebElement footertext;
	//texts
	@FindBy(xpath = "//span[@class='title']") private WebElement youtcarttext;
	@FindBy(xpath = "cart_quantity_label") private WebElement quantitytext;
	@FindBy(xpath = "//div[@class='cart_desc_label']")private WebElement descriptiontext;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")private WebElement carticon;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")private WebElement threedoticon;
	@FindBy(xpath = "//div[@class='app_logo']")private WebElement applogotitle;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")private WebElement cartcount;
	public Cart_page()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean VerifyshoppingCartPage()
	{
		carticon.click();
		return
				carticon.isDisplayed();
	}
	public String VerifyURLofCartPage()
	{
		return
				driver.getCurrentUrl();
	}
	public String verifyCartTitle()
	{
		return
				youtcarttext.getText();
	}
	public String Verifyquantitytext()
	{return
		quantitytext.getText();
	}
	public String verifydescriptiontext()
	{
		return
				descriptiontext.getText();
	}
	public String verifycontinuebutton()
	{
		return
				continuebutton.getText();
	}
	public String verifycheckoutbutton()
	{
		
				return checkoutbutton.getText();
		
	}
	public String verifyURLofCheckOutPage()
	{
		checkoutbutton.click();
		return driver.getCurrentUrl();
	}
	public void clickCheckoutbutton()
	{
		checkoutbutton.click();
	}
	public boolean verifycartTwitterlogo()
	{
		return 
				twitterImagelogo.isDisplayed();		
	}
	public boolean verifyfacebooklogo()
	{
		return
				facebooklogo.isDisplayed();
		
	}
	public boolean verifylinkdinlogo()
	{
		return
				linkdinlogo.isDisplayed();
	}
	public boolean verifythreedoticon()
	{
		return
				threedoticon.isDisplayed();
	}
	public boolean verifyfootertext()
	{
		return
				footertext.isDisplayed();
	}
	public String remove3productsCartPage() throws InterruptedException
	{
		carticon.click();
		removeproduct1.click();
		removeproduct2.click();
		removeproduct3.click();
		Thread.sleep(4000);
		return cartcount.getText();
	}
	

}

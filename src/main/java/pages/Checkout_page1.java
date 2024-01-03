package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Checkout_page1 extends Testbase
{//object repository
	@FindBy(xpath = "//input[@name='firstName']") private WebElement Firstname;
	@FindBy(xpath = "//input[@name='lastName']") private WebElement Lastname;
	@FindBy(xpath = "//input[@name='postalCode']") private WebElement Zipcode;
	@FindBy(xpath = "//span[@class='title']") private WebElement checkoutpagetext;
	@FindBy(xpath = "//input[@name='continue']")private WebElement continuebtn;
	public Checkout_page1()
	{
		PageFactory.initElements(driver, this);
		
	}
	public String VerifyURLofcheckoutpage1()
	{
		return driver.getCurrentUrl();
	}
	public String Verifycheckoutpagetext()
	{
		return checkoutpagetext.getText();
	}
	public String inputinformation()
	{
		Firstname.sendKeys("harry");
		Lastname.sendKeys("potter");
		Zipcode.sendKeys("444001");
		continuebtn.click();
		return driver.getCurrentUrl();
	}
	
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.annotations.VisibleForTesting;

import base.Testbase;

public class complete_page extends Testbase
{
	@FindBy(xpath = "//span[@class='title']")private WebElement completepagetxtlable;
	@FindBy(xpath = "//h2[@class='complete-header']")private WebElement ThankyouText;
	@FindBy(xpath = "//div[@class='complete-text']")private WebElement completetext;
	@FindBy(xpath = "//img[@class='pony_express']")private WebElement Displayimage;
	@FindBy(xpath = "//button[@name='back-to-products']")private WebElement backhomebtn;
	public complete_page()
	{
		PageFactory.initElements(driver, this);
	}
	public String VerifyURLofcompletepage()
	{
		return driver.getCurrentUrl();
	}
	public String Verifycompletepagetxtlable()
	{
		return completepagetxtlable.getText();
	}
	public String VerifyThankyouText()
	{
		return ThankyouText.getText();
	}
	public String Verifycompletetext()
	{
		return completetext.getText();
		
	}
	public boolean VerifyDisplayimage()
	{
		return Displayimage.isDisplayed();
	}
	public String Verifybackhomebtn()
	{
		 backhomebtn.click();
		 return driver.getCurrentUrl();
	}
}

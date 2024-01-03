package pages;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Checkout_Page2 extends Testbase
{
	//object repository
	@FindBy(xpath = "//span[@class='title']") private WebElement Checkoutpage2Text;
	@FindBy(xpath = "//div[@class='cart_quantity_label']")private WebElement QtyText;
	@FindBy(xpath = "//div[@class='cart_desc_label']") private WebElement descriptionText;
	@FindBy(xpath = "//button[@name='finish']")private WebElement Clickonfinishbtn;
	@FindBy(xpath = "//div[@class='summary_info_label']") private WebElement paymentinfoText;
public Checkout_Page2()
{
	PageFactory.initElements(driver, this);
	
}
public void VerifyCheckoutpage2Text()
	{
	    Checkoutpage2Text.getText();
	    QtyText.getText();
	    descriptionText.getText();
	    paymentinfoText.getText();
	    
	   
	}
public String verifyClickonfinishbtn()
{
	Clickonfinishbtn.click();
	return driver.getCurrentUrl();
	
	}



}


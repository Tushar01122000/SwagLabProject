package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mongodb.gridfs.CLI;

import base.Testbase;
import utility.HandleDropDownList;

public class Inventory_page2 extends Testbase
{
	//object repository
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement addTocart;
	@FindBy(xpath = "//Select[@class='product_sort_container']") private WebElement DropDown;
	//add to cart
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement sauceLabBackpack;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLight;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement sauceTshirt;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement sauceFleeceJacket;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement OneSide;
	
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement RedTShirt;
	//remove from cart
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removesaucelabBackpack;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikelight;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement removeTshirt;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removeFleeceJacket;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement removeoneSide;
	@FindBy(xpath = "remove-test.allthethings()-t-shirt-(red)")private WebElement removeRedTshirt;
	
	
	
	
	
	
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebooklogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedinlogo;
	@FindBy(xpath = "//div[@class='footer_copy']")private WebElement footerline;
	@FindBy(xpath = "//div[@class='app_logo']")private WebElement applogo;
	@FindBy(xpath = "//span[@class='title']")private WebElement productlable;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")private WebElement threelinebutton;
	//constructor
	public Inventory_page2()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyproductlable()
	{
		return productlable.getText();
	}
	public boolean veriftyLogo()
	{
		facebooklogo.isDisplayed();//true
		linkedinlogo.isDisplayed();
		applogo.isDisplayed();
		return twitterLogo.isDisplayed();
		
		
		
	}
	public String add6products()
	{
		HandleDropDownList.handleSelectClass(DropDown, "Price (low to high)");
		sauceLabBackpack.click();
		bikeLight.click();
		sauceTshirt.click();
		sauceFleeceJacket.click();
		OneSide.click();
		RedTShirt.click();
		return addTocart.getText();
	}
	public String remove2Products() throws InterruptedException
	{
		add6products();
		Thread.sleep(3000);
		removesaucelabBackpack.click();
		removebikelight.click();
		return addTocart.getText();
	}
	public String verityfooterLink()
	{
		return footerline.getText();
	}
	public void veriftythreeline()
	{
		 threelinebutton.click();
	}
	
	



}

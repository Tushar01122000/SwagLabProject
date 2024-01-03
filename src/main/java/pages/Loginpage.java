package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Testbase;
import utility.ReadData;

public class Loginpage extends Testbase

{	//object repository
	@FindBy(xpath = "//input[@id='user-name']") private WebElement userTxtBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement userPassBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement LoginButton;
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	public String loginToApplication() throws IOException 
	{
		logger= report.createTest("Login to Sauce Lab Application");
		userTxtBox.sendKeys(ReadData.readPropertyFile("username"));
		logger.log(Status.INFO,"username is entered");
		userPassBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO,"password is entered");
		LoginButton.click();
		logger.log(Status.INFO,"login button is clicked ");
		logger.log(Status.PASS,"login is successful");
		return driver.getCurrentUrl();
	}
	public String logintoappwithmulticreds(String un, String pass)
	{
		userTxtBox.sendKeys(un);
		
		userPassBox.sendKeys(pass);
		
		LoginButton.click();
		
		return driver.getCurrentUrl();
	}
	public String verifyTitleofApplication()
	{
		return driver.getTitle();
	}
	public String verifyURLofApplication()
	{
		return driver.getCurrentUrl();
	}
	
}

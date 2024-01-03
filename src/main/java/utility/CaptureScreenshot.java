package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.Testbase;

public class CaptureScreenshot extends Testbase
{
	public static String getData()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mmm-HH").format(new Date());
	}
	public static void ScreenShot(String nameOfMethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\tusha\\eclipse-workspace\\Selenium_framework_28\\Screenshot0\\"+ nameOfMethod+"--"+getData()+".jpeg");
		FileHandler.copy(source, dest);
		
	}
}

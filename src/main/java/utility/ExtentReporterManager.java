package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Testbase;
import freemarker.template.SimpleDate;

public class ExtentReporterManager extends Testbase
{		 static ExtentReports report;
		public static ExtentReports getReporterInstance()
		{
			if(report==null)
			{
				String reportName= new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
				ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter("C:\\Users\\tusha\\eclipse-workspace\\Selenium_framework_28\\ExtentReport\\report.html");
				report = new ExtentReports();
				report.attachReporter(htmlReporter);
				report.setSystemInfo("OS", "Windows");
				report.setSystemInfo("Environment", "SIT");
				report.setSystemInfo("Build Number", "102.02.02.126");
				report.setSystemInfo("Browser", "chrome");
				htmlReporter.config().setDocumentTitle("UI Testing Documents");
				htmlReporter.config().setReportName("UI Test REport");
			}
			return report;
		}
}

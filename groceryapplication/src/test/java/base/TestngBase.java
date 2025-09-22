package base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtility;

public class TestngBase {
	public WebDriver driver;
	@BeforeMethod
	public void intializebrowser() {
		//driver= new ChromeDriver();
		//driver=new FirefoxDriver();
		//driver=new EdgeDriver();
		ChromeOptions options = new ChromeOptions();
		Map<String,Object> prefs=new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
		driver=new ChromeDriver(options);
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void browserclose() {
		//driver.close();//tab
		//driver.quit();// window
	}
	
	@AfterMethod(alwaysRun = true)	
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
		if(iTestResult.getStatus()==ITestResult.FAILURE)
		{
			ScreenshotUtility screenShot=new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();

	}
	

}



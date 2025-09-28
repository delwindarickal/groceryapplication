package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestngBase;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestngBase {
	
	@Test (description = "Add new News in Manage news")
	public void verifyAddNews() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");// 2nd row 1st coloumn- username
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");// 2nd row 2nd coloumn - password
		/*WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block\']"));
		loginbutton.click();*/
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(usernameValue);
		login.enterPassword(passwordValue);
		login.clickLogin();
		
		/*WebElement newsmoreinfo=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		newsmoreinfo.click();
		WebElement add_newNews=driver.findElement(By.xpath("//a[@onclick='click_button(1)']"));
		add_newNews.click();
		
		WebElement newNews=driver.findElement(By.xpath("//textarea[@placeholder='Enter the news']"));
		newNews.sendKeys("Sample News");
		
		WebElement saveNews=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		saveNews.click();
		WebElement newsalert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		boolean isNewsAlertDisplayed = newsalert.isDisplayed();*/
		
		NewsPage news=new NewsPage(driver);
		news.newsMoreInfo();
		news.addNewNews();
		
		news.newnews();
		news.savenews();
		
		boolean isNewsAlertDisplayed = news.newsAlert();
		Assert.assertTrue(isNewsAlertDisplayed,"The News is not added");
		
		
		
	}
	@Test (description = "Return to home")
	public void verifyReturntohome() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");// 2nd row 1st coloumn- username
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");// 2nd row 2nd coloumn - password
		/*WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block\']"));
		loginbutton.click();*/
		LoginPage login=new LoginPage(driver);
		login.enterUsername(usernameValue);
		login.enterPassword(passwordValue);
		login.clickLogin();
		
	//	WebElement newsmoreinfo=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		//newsmoreinfo.click();
		
		NewsPage news=new NewsPage(driver);
		news.newsMoreInfo();
		
		//WebElement returntohome=driver.findElement(By.xpath("//a[text()='Home']"));
		//returntohome.click();
		news.returntoHome();
		
		String expected = "https://groceryapp.uniqassosiates.com/admin/home";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,"The page is not redirected to the home page from manage NewsS.");
		
		
		
	}

}

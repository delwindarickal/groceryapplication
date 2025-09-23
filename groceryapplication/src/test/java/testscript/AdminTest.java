package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestngBase;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestngBase {
	
	@Test( priority=1, description = "Add new User" )
	public void verifyAddUser() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");// 2nd row 1st coloumn- username
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");// 2nd row 2nd coloumn - password
		WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block\']"));
		loginbutton.click();
		
		FakerUtility fakerUtility = new FakerUtility();
		String randomname=fakerUtility.createRandomUserName();
		String randompassword=fakerUtility.createRandomPassword();
		//String usertype=ExcelUtility.getStringData(1,2, "HomePage");
		
		WebElement adminmoreinfo=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminmoreinfo.click();
		
		WebElement newuser=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newuser.click();
		
		WebElement newusername=driver.findElement(By.xpath("//input[@id='username']"));
		newusername.sendKeys(randomname);
		
		WebElement newpassword=driver.findElement(By.xpath("//input[@id='password']"));
		newpassword.sendKeys(randompassword);
		
		WebElement usertypedrpdown= driver.findElement(By.xpath("//select[@id='user_type']"));
		Select select=new Select(usertypedrpdown);
		//select.selectByVisibleText(usertype);
		select.selectByValue("admin");
		
		WebElement usersave= driver.findElement(By.xpath("//button[@name='Create']"));
		usersave.click();
		
		WebElement newsAlert= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		boolean isalertdisplayed=newsAlert.isDisplayed();
		Assert.assertTrue(isalertdisplayed,"The News is not added");// if false message will be displayed
		
		
		
		}
	@Test(priority = 2, description  = "search the user")
	
	public void verifysearchuser() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");// 2nd row 1st coloumn- username
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");// 2nd row 2nd coloumn - password
		WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block\']"));
		loginbutton.click();
		
		WebElement adminmoreinfo=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminmoreinfo.click();
		
		FakerUtility fakerUtility = new FakerUtility();
		String randomname=fakerUtility.createRandomUserName();
		
		WebElement search_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		search_button.click();
		
		WebElement search_username = driver.findElement(By.xpath("//input[@id='un']"));
		search_username.sendKeys(randomname);
		
		WebElement dropdown = driver.findElement(By.xpath("//Select[@id='ut']"));
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText("Admin");
		
		WebElement search_button_new = driver.findElement(By.xpath("//button[@name='Search']"));
		search_button_new.click();
		
		WebElement newsAlert= driver.findElement(By.xpath("//h4[@class=\"card-title\" and text() ='Admin Users']"));
		boolean isalertdisplayed=newsAlert.isDisplayed();
		Assert.assertTrue(isalertdisplayed,"The Search was successfull");// if false message will be displayed
		
		

	}
	
	@Test(priority = 3, description  = "Refresh button")
	
	public void verifyRefreshbutton() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");// 2nd row 1st coloumn- username
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");// 2nd row 2nd coloumn - password
		WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block\']"));
		loginbutton.click();
		
		WebElement adminmoreinfo=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminmoreinfo.click();
		
		WebElement search_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		search_button.click();
		
		WebElement reset_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
		reset_button.click();
		
		String expected="https://groceryapp.uniqassosiates.com/admin/list-admin";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected, "Reset was not successfully done!");
		
	}
	

}

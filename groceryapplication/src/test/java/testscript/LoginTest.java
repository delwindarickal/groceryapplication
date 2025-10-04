package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestngBase;
import constant.Constants;
import constant.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestngBase {
@Test(priority = 1, description = "verify login with valid credentials", retryAnalyzer = retry.Retry.class, groups= {"smoke"})	//flaky testcase
public void verifyloginwithValidCredentials() throws IOException {
	String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);// 2nd row 1st coloumn- username
	String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);// 2nd row 2nd coloumn - password
	
	LoginPage login = new LoginPage(driver);
	login.enterUsername(usernameValue);
	login.enterPassword(passwordValue);
	login.clickLogin();
	
	String expected="https://groceryapp.uniqassosiates.com/admin/home";
	String actual=driver.getCurrentUrl();
	Assert.assertEquals(actual, expected, Messages.VALIDLOGIN_ASSERT);
	
}
@Test(priority = 2, description = "verify with valid username and invalid password ")
public void verifyloginwithValidUsernameInvalidpassword() throws IOException {
	String usernameValue=ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);// 3rd row 1st coloumn- username
	String passwordValue=ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);// 3rd row 2nd coloumn - password
	
	LoginPage login = new LoginPage(driver);
	login.enterUsername(usernameValue);
	login.enterPassword(passwordValue);
	login.clickLogin();
	
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	String actual = driver.getCurrentUrl();
	Assert.assertEquals(actual, expected, Messages.VALIDUSERINVALIDPASS_ASSERT);
	
}

@Test(priority = 3, description = "verfiy with invalid username and valid password")
public void verifyloginwithInvalidusernameValidPassword() throws IOException {
	String usernameValue=ExcelUtility.getStringData(3, 0, Constants.LOGINSHEET);// 4th row 1st coloumn- username
	String passwordValue=ExcelUtility.getStringData(3, 1, Constants.LOGINSHEET);// 4th row 2nd coloumn - password

	LoginPage login = new LoginPage(driver);
	login.enterUsername(usernameValue);
	login.enterPassword(passwordValue);
	login.clickLogin();
	
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	String actual = driver.getCurrentUrl();
	Assert.assertEquals(actual, expected, Messages.INVALIDUSERVALIDPASS_ASSERT);
}

@Test(priority = 4, description = "verify with invalid username and invaild password", dataProvider = "loginProvider")
public void verifyloginwithInvalidCredentials(String usernameValue, String passwordValue) throws IOException {
	//String usernameValue=ExcelUtility.getStringData(4, 0, "LoginPage");// 5th row 1st coloumn- username
	//String passwordValue=ExcelUtility.getStringData(4, 1, "LoginPage");// 5th row 2nd coloumn - password

	LoginPage login = new LoginPage(driver);
	login.enterUsername(usernameValue);
	login.enterPassword(passwordValue);
	login.clickLogin();
	
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	String actual = driver.getCurrentUrl();
	Assert.assertEquals(actual, expected, Messages.INVALIDUCREDENTIALS_ASSERT);
	
}

@DataProvider(name="loginProvider")	//returns two dimensional object array
public Object[][] getDataFromDataProvider() throws IOException
{
	return new Object[][] { new Object[] {"user","password"},
		new Object[] {"username","pass"},
		new Object[] {"user1","password1"}
	};
}
}


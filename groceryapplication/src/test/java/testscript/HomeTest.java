package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestngBase;
import utilities.ExcelUtility;

public class HomeTest extends TestngBase {
	@Test(description = "verify the logout")
	public void verifylogout() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");// 2nd row 1st coloumn- username
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");// 2nd row 2nd coloumn - password
		WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block\']"));
		loginbutton.click();
		WebElement logout=driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		logout.click();
		WebElement logoutclick=driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		logoutclick.click();

	}
}
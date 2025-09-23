package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	
	}
	public void enterUsername(String usernameValue) {
		
		WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		
	}
	public void enterPassword(String passwordValue) {
		
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
	}
		
	public void clickLogin() {
		WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block\']"));
		loginbutton.click();
	}
	

}

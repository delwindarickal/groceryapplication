package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	
	PageUtility pageUtility = new PageUtility();
	WaitUtility waitUtility = new WaitUtility();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath="//input[@name='username']")WebElement username;
	public void enterUsername(String usernameValue) {
		
		//WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
		//username.sendKeys(usernameValue);
		waitUtility.waitUntilElementIsVisible(driver, username);
		pageUtility.sendDataToElement(username, usernameValue);
		
	}
	@FindBy(xpath ="//input[@name='password']" ) WebElement password;
	public void enterPassword(String passwordValue) {
		
		//WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		//password.sendKeys(passwordValue);
		waitUtility.waitUntilElementIsVisible(driver, password);
		pageUtility.sendDataToElement(password, passwordValue);
	}
	
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block\']" )WebElement loginbutton;
	public void clickLogin() {
		//WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block\']"));
		//loginbutton.click();
		waitUtility.waitUntilClickable(driver, loginbutton);
		pageUtility.clickOnElement(loginbutton);
	}
	

}

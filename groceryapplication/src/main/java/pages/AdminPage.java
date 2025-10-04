package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.devtools.v133.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import constant.Constants;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
	public WebDriver driver;
	
	PageUtility pageUtility = new PageUtility();
	WaitUtility waitUtility=new WaitUtility();
	
	public AdminPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreinfo;
public void adminMoreInfo() {
	//WebElement adminmoreinfo=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
	//adminmoreinfo.click();
	pageUtility.clickOnElement(adminmoreinfo);
}
@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")WebElement newuser;
public void addnewuser() {
//	WebElement newuser =driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
	//newuser.click();
	pageUtility.clickOnElement(newuser);
}
@FindBy(xpath = "//input[@id='username']")WebElement newusername;
public void addNewUsername(String randomname) {
	//WebElement newusername = driver.findElement(By.xpath("//input[@id='username']"));
	//newusername.sendKeys(randomname);
	pageUtility.sendDataToElement(newusername, randomname);
}

@FindBy(xpath = "//input[@id='password']")WebElement newpassword;
public void enterNewPassword(String randompassword) {
	//WebElement newpassword = driver.findElement(By.xpath("//input[@id='password']"));
	//newpassword.sendKeys(randompassword);
	pageUtility.sendDataToElement(newpassword, randompassword);
}

@FindBy(xpath = "//select[@id='user_type']")WebElement usertypedropdown;
public void userTypeDropdown() {
	//WebElement newusertype =driver.findElement(By.xpath("//select[@id='user_type']"));
	//Select select = new Select(newusertype);
	//select.selectByVisibleText("Admin");
	pageUtility.selectDataWithVisibleText(usertypedropdown, Constants.ADMINUSER);
}

@FindBy(xpath = "//button[@name='Create']")WebElement usersave;
public void userSave() {
	//WebElement usersave = driver.findElement(By.xpath("//button[@name='Create']"));
	//usersave.click();
	pageUtility.clickOnElement(usersave);
	waitUtility.waitUntilClickable(driver, usersave);
}

@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']" )WebElement newAlert;
public boolean newAlert() {
	
	//WebElement newsAlert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
	return newAlert.isDisplayed();
}

@FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']" )WebElement search_button;
public void searchButton() {
	//WebElement search_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
	//usersearch.click();
	pageUtility.clickOnElement(search_button);
}

@FindBy(xpath ="//input[@id='un']" )WebElement search_username;
public void searchUserName(String randomname) {
	//WebElement search_username = driver.findElement(By.xpath("//input[@id='un']"));
	//searchusername.sendKeys(randomname);
	pageUtility.sendDataToElement(search_username, randomname);
}

@FindBy(xpath = "//select[@name='ut']")WebElement searchusertype;
public void searchUserType() {
	//WebElement searchusertype = driver.findElement(By.xpath("//select[@name='ut']"));
	//Select select = new Select(searchusertype);
	//select.selectByVisibleText("Admin");
	pageUtility.selectDataWithVisibleText(searchusertype, Constants.ADMINUSER);
}

@FindBy(xpath ="//button[@name='Search']" )WebElement searchuser;
public void searchUser() {
	//WebElement searchuser = driver.findElement(By.xpath("//button[@name='Search']"));
	//searchuser.click();
	pageUtility.clickOnElement(searchuser);
	
}

@FindBy(xpath ="//button[@class='btn btn-block-sm btn-danger' and @name = 'Search']" )WebElement searchalert;
public boolean searchAlert() {
	//WebElement searchalert = driver.findElement(By.xpath("//button[@class='btn btn-block-sm btn-danger' and @name = 'Search']"));
	return searchalert.isDisplayed();
}

@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") WebElement reset_button;
public void reset() {
	//WebElement reset = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
	//reset.click();
	pageUtility.clickOnElement(reset_button);
	
}

@FindBy(xpath ="//h4[@class='card-title' and text() ='Admin Users']" )WebElement resetalert;
public boolean resetAlert() {
	//WebElement resetalert = driver.findElement(By.xpath("//h4[@class='card-title' and text() ='Admin Users']"));
	return resetalert.isDisplayed();
}

}
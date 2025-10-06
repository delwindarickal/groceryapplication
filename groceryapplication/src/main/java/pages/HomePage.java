package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	
	PageUtility pageUtility=new PageUtility();
	WaitUtility waitUtility = new WaitUtility();
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

@FindBy(xpath ="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']" )WebElement adminbutton;
public HomePage admin_button() {	
	//WebElement adminbutton=driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
	//adminbutton.click();
	pageUtility.clickOnElement(adminbutton);
	return this;
	
}
@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")WebElement logoutbutton;
public LoginPage logout_button() { // returning to login page
	//WebElement logoutbutton=driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
	//logoutbutton.click();
	waitUtility.waitUntilClickable(driver, logoutbutton);
	pageUtility.clickOnElement(logoutbutton);
	return new LoginPage(driver);
}

@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreinfo;
public AdminPage adminMoreInfo() {
	//WebElement adminmoreinfo=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
	//adminmoreinfo.click();
	pageUtility.clickOnElement(adminmoreinfo);
	return new AdminPage(driver);
}
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newsmoreinfo;
public NewsPage newsMoreInfo() {
//WebElement newsmoreinfo=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
//newsmoreinfo.click();
pageUtility.clickOnElement(newsmoreinfo);	
return new NewsPage(driver); 
}
}

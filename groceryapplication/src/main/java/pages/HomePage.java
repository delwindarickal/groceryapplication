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
public void admin_button() {	
	//WebElement adminbutton=driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
	//adminbutton.click();
	pageUtility.clickOnElement(adminbutton);
	
}
@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")WebElement logoutbutton;
public void logout_button() {
	//WebElement logoutbutton=driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
	//logoutbutton.click();
	waitUtility.waitUntilClickable(driver, logoutbutton);
	pageUtility.clickOnElement(logoutbutton);
}
}

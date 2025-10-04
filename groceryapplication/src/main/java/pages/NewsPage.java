package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class NewsPage {
	public WebDriver driver;
	
	PageUtility pageUtility=new PageUtility();
	WaitUtility waitUtility=new WaitUtility();
	
	public NewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newsmoreinfo;
	public void newsMoreInfo() {
	//WebElement newsmoreinfo=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
	//newsmoreinfo.click();
	pageUtility.clickOnElement(newsmoreinfo);	
	}
	
	@FindBy(xpath ="//a[@onclick='click_button(1)']" )WebElement add_newNews;
	public void addNewNews() {
		//WebElement add_newNews=driver.findElement(By.xpath("//a[@onclick='click_button(1)']"));
		//add_newNews.click();
		pageUtility.clickOnElement(add_newNews);
	}
	
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")WebElement newNews;
	public void newnews() {
	//WebElement newNews=driver.findElement(By.xpath("//textarea[@placeholder='Enter the news']"));
	//newNews.sendKeys("Sample News");
		pageUtility.sendDataToElement(newNews, "Sample News");
	}
	
	@FindBy(xpath ="//button[@class='btn btn-danger']" )WebElement saveNews;
	public void savenews() {
	//WebElement saveNews=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	//saveNews.click();
		waitUtility.waitUntilClickable(driver, saveNews);
		pageUtility.clickOnElement(saveNews);
	}
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement newsalert;
	public boolean newsAlert() {
		
		//WebElement newsAlert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		return newsalert.isDisplayed();
	}
	
	@FindBy(xpath ="//a[text()='Home']" )WebElement returntohome;
	public void returntoHome() {
	//WebElement returntohome=driver.findElement(By.xpath("//a[text()='Home']"));
	//returntohome.click();
	pageUtility.clickOnElement(returntohome);
	}
}

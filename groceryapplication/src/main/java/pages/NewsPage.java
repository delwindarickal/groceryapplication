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
	
	
	@FindBy(xpath ="//a[@onclick='click_button(1)']" )WebElement add_newNews;
	public NewsPage addNewNews() {
		//WebElement add_newNews=driver.findElement(By.xpath("//a[@onclick='click_button(1)']"));
		//add_newNews.click();
		pageUtility.clickOnElement(add_newNews);
		return this;
	}
	
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")WebElement newNews;
	public NewsPage newnews() {
	//WebElement newNews=driver.findElement(By.xpath("//textarea[@placeholder='Enter the news']"));
	//newNews.sendKeys("Sample News");
		pageUtility.sendDataToElement(newNews, "Sample News");
		return this;
	}
	
	@FindBy(xpath ="//button[@class='btn btn-danger']" )WebElement saveNews;
	public NewsPage savenews() {
	//WebElement saveNews=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	//saveNews.click();
		waitUtility.waitUntilClickable(driver, saveNews);
		pageUtility.clickOnElement(saveNews);
		return this;
	}
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement newsalert;
	public boolean newsAlert() {
		
		//WebElement newsAlert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		return newsalert.isDisplayed();
	}
	
	@FindBy(xpath ="//a[text()='Home']" )WebElement returntohome;
	public HomePage returntoHome() {
	//WebElement returntohome=driver.findElement(By.xpath("//a[text()='Home']"));
	//returntohome.click();
	pageUtility.clickOnElement(returntohome);
	return new HomePage(driver);
	}
}

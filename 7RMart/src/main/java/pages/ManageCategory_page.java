package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategory_page {
	
	public WebDriver driver;
	
	public ManageCategory_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[11]")private WebElement moreinfoManageCategory;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement new_button;
	@FindBy(xpath="//input[@class='form-control']")private WebElement inputCategory_field;
	@FindBy(xpath="(//span[text()='discount'])[1]")private WebElement discount_button;
	@FindBy(xpath="//input[@id='main_img']")private WebElement choosefile;
//	@FindBy(xpath="(//input[@type='radio'])[2]")private WebElement showOnTopMenu_button;
//	@FindBy(xpath="(//input[@type='radio'])[4]")private WebElement showOnLeftMenu_button;
	@FindBy(xpath="//button[text()='Save']")private WebElement save_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertmsg;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement search_button;
	@FindBy(xpath="//input[@class='form-control']")private WebElement categorySearch_field;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")private WebElement submitSearch_button;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")private WebElement delete_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertMsg;
	
	
	
	
	public void clickMoreInfoManageCategory()
	{
		moreinfoManageCategory.click();
	}
	
	public void clickNewButton() 
	{
		new_button.click();
	}
	public void inputCategory_field(String category) 
	{
		inputCategory_field.sendKeys(category);
	}
	
	public void clickDiscount()
	{
		discount_button.click();
	}
	
	public void uploadFile()
	{
		choosefile.sendKeys("C:\\Users\\Arun\\Downloads\\mogu-guava.jpg");
		
	}
//	
//	public void clickRadioButtonTopMenu()
//	{
//		showOnTopMenu_button.click();
//	}
//	public void clickRadioButtonLeftMenu()
//	{
//		showOnLeftMenu_button.click();
//	}
	
	
	public void clickSaveButton()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",save_button );
		js.executeScript("arguments[0].click();", "");

		
		save_button.click();
	}
	public boolean verifyAlert()
	{
		return alertmsg.isDisplayed();
	}
	
	public void clickSearchButton()
	{
		search_button.click();
	}
	public void inputCategoryfield(String searchCategory)
	{
		categorySearch_field.sendKeys(searchCategory);
	}
	public void clickSubmitSearch()
	{
		submitSearch_button.click();
	}

	public void clickDeleteButton()
	{
		delete_button.click();
		driver.switchTo().alert().accept();
	}
	
	public boolean checkAlertMsg() 
	{
		return alertMsg.isDisplayed();
		
	}
}


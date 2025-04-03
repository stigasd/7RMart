package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Page_utilities;

public class SubCategory_page {
	
	public WebDriver driver;
	
	public SubCategory_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement new_button ;
	@FindBy(xpath="//select[@id='cat_id']")private WebElement category_dropdown;
	@FindBy(xpath="//input[@id='subcategory']")private WebElement subCategory_field ;
	@FindBy(xpath="//input[@id='main_img']")private WebElement uploadImage_button;
	@FindBy(xpath="//button[@type='submit']")private WebElement save_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alermsg;
	
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]")private WebElement delete_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement deleteAlertMsg;
	
	
	public SubCategory_page clickNewButton() 
	{
		new_button.click();
		return this;
	}
	public SubCategory_page selectCategory()
	{
		Page_utilities pageutilities=new Page_utilities();
		pageutilities.selectByIndex(category_dropdown,3);
		return this;
	}
	
	public SubCategory_page inputSubCategory_field(String datainput)
	{
		subCategory_field.sendKeys(datainput);
		return this;
	}
	public SubCategory_page uploadImage()
	{
		uploadImage_button.sendKeys("C:\\Users\\Arun\\Downloads\\mango.jpg");
		return this;
	}
	
	public SubCategory_page clickSaveButton()
	{
		save_button.click();
		return this;
	}
	
	public boolean verifyAlertMsg()
	{
		return alermsg.isDisplayed();
		
	}
	
	public SubCategory_page deleteSubCategory()
	{
		delete_button.click();
		driver.switchTo().alert().accept();
		return this;
	}
	public boolean verifyDeleteAlertMsg()
	{
		return deleteAlertMsg.isDisplayed();
	}

}

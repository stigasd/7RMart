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
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[4]")private WebElement moreinfo_SubCategory ;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement new_button ;
	@FindBy(xpath="//select[@id='cat_id']")private WebElement category_dropdown;
	@FindBy(xpath="//input[@id='subcategory']")private WebElement subCategory_field ;
	@FindBy(xpath="//input[@id='main_img']")private WebElement uploadImage_button;
	@FindBy(xpath="//button[@type='submit']")private WebElement save_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alermsg;
	
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]")private WebElement delete_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement deleteAlertMsg;
	
	public void clickMoreInfo()
	{
		moreinfo_SubCategory.click();
	}
	
	public void clickNewButton() 
	{
		new_button.click();
	}
	public void selectCategory()
	{
		Page_utilities pageutilities=new Page_utilities();
		pageutilities.selectByIndex(category_dropdown,3);
	}
	
	public void inputSubCategory_field(String datainput)
	{
		subCategory_field.sendKeys(datainput);
	}
	public void uploadImage()
	{
		uploadImage_button.sendKeys("C:\\Users\\Arun\\Downloads\\mango.jpg");
	}
	
	public void clickSaveButton()
	{
		save_button.click();
	}
	
	public boolean verifyAlertMsg()
	{
		return alermsg.isDisplayed();
		
	}
	
	public void deleteSubCategory()
	{
		delete_button.click();
		driver.switchTo().alert().accept();
	}
	public boolean verifyDeleteAlertMsg()
	{
		return deleteAlertMsg.isDisplayed();
	}

}

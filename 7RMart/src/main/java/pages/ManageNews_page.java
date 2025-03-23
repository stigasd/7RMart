package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews_page {
	
	public WebDriver driver; //globally 
	
	public ManageNews_page(WebDriver driver) // constructor
	{
		this.driver=driver;
	    PageFactory.initElements(driver,this); 
		
	}

	@FindBy(xpath="//p[text()='Manage News']//parent::a")private WebElement manageNews_box;
	@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[9]")private WebElement moreinfo_button;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newClick_button;
	@FindBy(xpath="//textarea[@id='news']")private WebElement newsInput_field;
	@FindBy(xpath="//button[@type='submit']")private WebElement save_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertBox;
	
	
	

	
	public void moreInfo()
	{
		moreinfo_button.click();
	}
	public void newClick()
	{
		newClick_button.click();	
	}
	public void enterNews(String news)
	{
		newsInput_field.sendKeys(news);
		
	}
	public void saveNews()
	{
		save_button.click();
	}
	public boolean isSuccessAlertMessageLoaded()
	{
		return alertBox.isDisplayed();
		
	}
	
	
	
	
	

}

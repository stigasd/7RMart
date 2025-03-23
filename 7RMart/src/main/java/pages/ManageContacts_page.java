package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContacts_page {
	
	public WebDriver driver;  // globally
	
	public ManageContacts_page(WebDriver driver) //constructor
	{
		this.driver=driver;
		PageFactory.initElements( driver,this); //webelements initialize cheyan
		
		
	}
	
	@FindBy(xpath="(//a[text()='More info '])[5]")private WebElement moreInfo;
	@FindBy(xpath="//a[@role='button']")private WebElement action_button;
	
	@FindBy(xpath="//input[@id='phone']")private WebElement phone_field;
	@FindBy(xpath="//input[@id='email']")private WebElement email_field ;
	@FindBy(xpath="(//textarea[@id='content'])[1]")private WebElement address_field ;
	@FindBy(xpath="(//textarea[@id='content'])[2]")private WebElement deliveryTime_field;
	@FindBy(xpath="//input[@id='del_limit']")private WebElement deliveryCharge_field;
	@FindBy(xpath="//button[@name='Update']")private WebElement update_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert_button;
	
	
	
	
	
	
	public void loginButton()
	{
		moreInfo.click();
		action_button.click();
	}
	
	public void enterPhoneNumber(String phone)
	{
		phone_field.clear();
		phone_field.sendKeys(phone);
		
	}
	

	public void enterEmail(String email)
	{
	email_field.clear();
	email_field.sendKeys(email);
	}
		
	public void enteraddress(String address)
	{
	address_field.clear();
	address_field.sendKeys(address);
		
	}
	public void enterDeliveryTime(String deliveryTime)
	{
	deliveryTime_field.clear();
	deliveryTime_field.sendKeys(deliveryTime);
	}
	public void enterDeliveryCharge(String deliveryCharge)
	{
	deliveryCharge_field.sendKeys(deliveryCharge);
	update_button.click();
	}	
	public void pressUpdate()
	{
		update_button.click();
	}
	
	public boolean isAlertLoaded()
	{
		return alert_button.isDisplayed();
	}
	
	


}

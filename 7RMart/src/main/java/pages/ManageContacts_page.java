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
	
	
	@FindBy(xpath="//a[@role='button']")private WebElement action_button;
	
	@FindBy(xpath="//input[@id='phone']")private WebElement phone_field;
	@FindBy(xpath="//input[@id='email']")private WebElement email_field ;
	@FindBy(xpath="(//textarea[@id='content'])[1]")private WebElement address_field ;
	@FindBy(xpath="(//textarea[@id='content'])[2]")private WebElement deliveryTime_field;
	@FindBy(xpath="//input[@id='del_limit']")private WebElement deliveryCharge_field;
	@FindBy(xpath="//button[@name='Update']")private WebElement update_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert_button;
	
	
	
	
	public ManageContacts_page clickActionButton()
	{
		action_button.click();
		return this;
	}
	
	
	public ManageContacts_page enterPhoneNumber(String phone)
	{
		phone_field.clear();
		phone_field.sendKeys(phone);
		return this;
		
	}
	

	public ManageContacts_page enterEmail(String email)
	{
	email_field.clear();
	email_field.sendKeys(email);
	return this;
	}
		
	public ManageContacts_page enteraddress(String address)
	{
	address_field.clear();
	address_field.sendKeys(address);
	return this;
		
	}
	public ManageContacts_page enterDeliveryTime(String deliveryTime)
	{
	deliveryTime_field.clear();
	deliveryTime_field.sendKeys(deliveryTime);
	return this;
	}
	public ManageContacts_page enterDeliveryCharge(String deliveryCharge)
	{
	deliveryCharge_field.sendKeys(deliveryCharge);
	update_button.click();
	return null;
	}	
	public ManageContacts_page manageContactsUpdateButton()
	
	{
		update_button.click();
		return this;
		
	}
	
	public boolean isAlertLoaded()
	{
		return alert_button.isDisplayed();
	}
	
	


}

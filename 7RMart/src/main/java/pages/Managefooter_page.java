package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managefooter_page {
	
	public WebDriver driver;
	
	public Managefooter_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	
	@FindBy(xpath="(//i[@class='fas fa-edit'])[1]")private WebElement action_button;
	@FindBy(xpath="//textarea[@id='content']")private WebElement addressInput_field;
	@FindBy(xpath="//input[@id='email']")private WebElement emailInput_field;
	@FindBy(xpath="//input[@id='phone']")private WebElement phoneInput_field;
	@FindBy(xpath="//button[@name='Update']")private WebElement update_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertmsg;
	

	public Managefooter_page clickAction_footer()
	{
		action_button.click();
		return this;
	}
	public Managefooter_page enterAddress(String address)
	{
		addressInput_field.clear();
		addressInput_field.sendKeys(address);
		return this;
	}
	public Managefooter_page enterEmail(String email)
	{
		emailInput_field.clear();
		emailInput_field.sendKeys(email);
		return this;
	}
	public Managefooter_page enterPhone(String phone)
	{
		phoneInput_field.clear();
		phoneInput_field.sendKeys(phone);
		return this;
	}
	public Managefooter_page clickUpdate()
	{
		update_button.click();
		return this;
		
	}
	
	public boolean verifyAlert()
	{
		return alertmsg.isDisplayed();
		
	}

}

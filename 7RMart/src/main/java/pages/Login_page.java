package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	public WebDriver driver;
	
	public Login_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")private WebElement username_field;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement password_field;
	@FindBy(xpath="//button[@type='submit']")private WebElement signIn_button;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alertmsg;
	
	public Login_page enterUserName(String username)
	{
		username_field.sendKeys(username);
		return this;
	}
	public Login_page enterPassword(String password)
	{
		password_field.sendKeys(password);
		return this;
	}
	public Home_page clickSignIn()
	{
		signIn_button.click();
		return new Home_page(driver) ;
	}
	
	public boolean isHomePageLoaded()
	{
		return dashboard.isDisplayed();
		
	}
	public boolean checkAlertMsg() 
	{
		return alertmsg.isDisplayed();
		
	}

}

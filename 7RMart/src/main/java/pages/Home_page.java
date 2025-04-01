package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	
	public WebDriver driver;
	
	public Home_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	
	@FindBy(xpath="(//a[@class='nav-link'])[2]")private WebElement admin_button;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")private WebElement logout_button;
	@FindBy(xpath="//p[text()='Sign in to start your session']")private WebElement verifylogout ;
	
	
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")private WebElement moreinfo_button ;
	
	
	public AdminUsers_page moreinfo_AdminUser() 
	{
		moreinfo_button.click();
		return new AdminUsers_page(driver);

		
	}
	public void adminButtonPress()
	{
		admin_button.click();
	}
	public void logoutButtonPress()
	{
		logout_button.click();
	}
	
	public boolean verifyLogout()
	{
		return verifylogout.isDisplayed();
	}

}

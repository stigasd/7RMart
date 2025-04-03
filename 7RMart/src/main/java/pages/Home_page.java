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
	@FindBy(xpath="(//a[@class='small-box-footer'])[11]")private WebElement moreinfoManageCategory;
	@FindBy(xpath="(//a[@class='small-box-footer'])[4]")private WebElement moreinfo_SubCategory ;
	@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[9]")private WebElement moreinfobutton;
	@FindBy(xpath="(//a[text()='More info '])[10]")private WebElement footer_moreinfo;
	@FindBy(xpath="(//a[text()='More info '])[5]")private WebElement moreInfo;
	
	
	public AdminUsers_page moreinfo_AdminUser() 
	{
		moreinfo_button.click();
		return new AdminUsers_page(driver);
	}
	
	public ManageCategory_page clickMoreInfoManageCategory()
	{
		moreinfoManageCategory.click();
		return new ManageCategory_page(driver);
	}
	public SubCategory_page clickMoreInfo()
	{
		moreinfo_SubCategory.click();
		return new SubCategory_page(driver);
	}
	
	public ManageNews_page moreInfo()
	{
		moreinfobutton.click();
		return new ManageNews_page(driver);
	}
	
	public Managefooter_page clickMoreinfo_footer()
	{
		footer_moreinfo.click();
		return new Managefooter_page(driver);
	}

	public  ManageContacts_page  moreinfoManageContact()
	{
		moreInfo.click();
		return new ManageContacts_page(driver);
		
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

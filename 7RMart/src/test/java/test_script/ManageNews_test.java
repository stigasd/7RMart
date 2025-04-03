package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.Home_page;
import pages.Login_page;
import pages.ManageNews_page;
import utilities.Excel_utilities;


public class ManageNews_test extends Base{
	public Home_page homepage;
	public ManageNews_page managenewspage;
	@Test(priority=1,description="manageNewsInput")
	public void manageNewsInput() throws Exception
	{   
		

		String username=Excel_utilities.getStringdata(1,0,"loginpage");  //excel read
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		String news=Excel_utilities.getStringdata(1,0,"managenews"); 
		Login_page loginobj=new Login_page(driver);
		loginobj.enterUserName(username).enterPassword(password);
		homepage=loginobj.clickSignIn();
		
		
		managenewspage=homepage.moreInfo().newClick().enterNews(news).saveNews();
	    boolean alertVerification=managenewspage.isSuccessAlertMessageLoaded();
	    Assert.assertTrue(alertVerification,Constants.MANAGENEWSINPUT);
	    
		
		
	}
}

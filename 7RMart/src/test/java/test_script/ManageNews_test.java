package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.Login_page;
import pages.ManageNews_page;
import utilities.Excel_utilities;


public class ManageNews_test extends Base{
	@Test(priority=1,description="manageNewsInput")
	public void manageNewsInput() throws Exception
	{   
		

		String username=Excel_utilities.getStringdata(1,0,"loginpage");  //excel read
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		Login_page loginobj=new Login_page(driver);
		loginobj.enterUserName(username);
		loginobj.enterPassword(password);
		loginobj.clickSignIn();
		loginobj.isHomePageLoaded();
		
		
		//creating object of other page class
		
		ManageNews_page manageNews=new ManageNews_page(driver);
		manageNews.moreInfo();
		manageNews.newClick();
		//String news="Diwali sale on Myntra tonight";
		
		String news=Excel_utilities.getStringdata(1,0,"managenews");   //excel read
		manageNews.enterNews(news);
		manageNews.saveNews();
	    boolean alertVerification=manageNews.isSuccessAlertMessageLoaded();
	    Assert.assertTrue(alertVerification,Constants.MANAGENEWSINPUT);
	    
		
		
	}
}

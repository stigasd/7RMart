package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;
import utilities.Excel_utilities;

public class Login_test extends Base {
	@Test(groups= {"Regression"},description="verifyLoginWithValidCredentials")
	public void verifyLoginWithValidCredentials() throws Exception
	{
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		
		
		Login_page pagelogin=new Login_page(driver);
		pagelogin.enterUserName(username);
		pagelogin.enterPassword(password);
		pagelogin.clickSignIn();
		pagelogin.isHomePageLoaded();
		boolean isloaded=pagelogin.isHomePageLoaded();
		Assert.assertTrue(isloaded, "home page not login with correct credentials");
		
		
		
	}
	@Test(description="verifyInvalidePasswordEntry")
	public void verifyInvalidePasswordEntry() throws IOException
	{
		String username=Excel_utilities.getStringdata(2,0,"loginpage");
		String password=Excel_utilities.getStringdata(2,1,"loginpage");
		
		Login_page pagelogin=new Login_page(driver);
		pagelogin.enterUserName(username);
		pagelogin.enterPassword(password);
		pagelogin.clickSignIn();
		boolean checkAlert=pagelogin.checkAlertMsg();
		Assert.assertTrue(checkAlert,"Green Alert not displayed ");
		
		
		
	}
	@Test(description="verifyInvalideUserNameEntry")
	public void verifyInvalideUserNameEntry() throws IOException
	{
		String username=Excel_utilities.getStringdata(3,0,"loginpage");
		String password=Excel_utilities.getStringdata(3,1,"loginpage");
		
		Login_page pagelogin=new Login_page(driver);
		pagelogin.enterUserName(username);
		pagelogin.enterPassword(password);
		pagelogin.clickSignIn();
		boolean checkAlert=pagelogin.checkAlertMsg();
		Assert.assertTrue(checkAlert,"Green Alert not displayed");
		
		
		
	}
	@Test(description="verifyInvalidUsernameAndPassword")
	public void verifyInvalidUsernameAndPassword() throws IOException
	{
		String username=Excel_utilities.getStringdata(4,0,"loginpage");
		String password=Excel_utilities.getStringdata(4,1,"loginpage");
		Login_page pagelogin=new Login_page(driver);
		pagelogin.enterUserName(username);
		pagelogin.enterPassword(password);
		pagelogin.clickSignIn();
		boolean checkAlert=pagelogin.checkAlertMsg();
		Assert.assertTrue(checkAlert,"Green alert not displayed");
		
	}

}

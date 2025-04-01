package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;
import pages.Home_page;
import utilities.Excel_utilities;

public class Home_test extends Base {
	@Test(groups={"Regression"},description="logout")
	public void logout() throws IOException
	{

		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		


		Login_page login=new Login_page(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickSignIn();
		login.isHomePageLoaded();
		
		Home_page pagelogout=new Home_page(driver);
		pagelogout.adminButtonPress();
		pagelogout.logoutButtonPress();
		boolean verifylogout = pagelogout.verifyLogout();
		Assert.assertTrue(verifylogout, "not displayed");
		
		
	}

}

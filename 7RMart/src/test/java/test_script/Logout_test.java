package test_script;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Login_page;
import pages.Logout_page;
import utilities.Excel_utilities;

public class Logout_test extends Base {
	@Test(groups={"Regression"})
	public void logout() throws IOException
	{

		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		


		Login_page login=new Login_page(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickSignIn();
		login.isHomePageLoaded();
		
		Logout_page pagelogout=new Logout_page(driver);
		pagelogout.adminButtonPress();
		pagelogout.logoutButtonPress();
		pagelogout.verifyLogout();
		
	}

}

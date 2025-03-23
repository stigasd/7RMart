package test_script;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Login_page;
import pages.Managefooter_page;
import utilities.Excel_utilities;

public class Managefooter_test extends Base {

	@Test
	public void footerText() throws IOException 
	{
	
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		String address=Excel_utilities.getStringdata(1,0,"managefooter");
		String email=Excel_utilities.getStringdata(1,1,"managefooter");
		String phone=Excel_utilities.getIntegerdata(1,2,"managefooter");

		Login_page login=new Login_page(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickSignIn();
		login.isHomePageLoaded();
		
		
		Managefooter_page managefooter=new Managefooter_page(driver);
		managefooter.clickMoreinfo_footer();
		managefooter.clickAction_footer();
		managefooter.enterAddress(address);
		managefooter.enterEmail(email);
		managefooter.enterPhone(phone);
		managefooter.clickUpdate();
		managefooter.verifyAlert();
		
	
	}

}
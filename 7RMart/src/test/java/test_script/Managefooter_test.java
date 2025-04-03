package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.Home_page;
import pages.Login_page;
import pages.Managefooter_page;
import utilities.Excel_utilities;

public class Managefooter_test extends Base {
	public Managefooter_page managefooterpage;
	public Home_page homepage;

	@Test(description="manageFooterText")
	public void manageFooterText() throws IOException 
	{
	
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		String address=Excel_utilities.getStringdata(1,0,"managefooter");
		String email=Excel_utilities.getStringdata(1,1,"managefooter");
		String phone=Excel_utilities.getIntegerdata(1,2,"managefooter");

		Login_page login=new Login_page(driver);
		login.enterUserName(username).enterPassword(password);
		homepage=login.clickSignIn();
		managefooterpage=homepage.clickMoreinfo_footer().clickAction_footer().enterAddress(address).enterEmail(email).enterPhone(phone).clickAction_footer();
	    boolean verifyAlert=managefooterpage.verifyAlert();
	    Assert.assertTrue(verifyAlert,Constants.MANAGEFOOTERINPUT);
		
	
	}

}
package test_script;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.AdminUsers_page;
import pages.Home_page;
import pages.Login_page;
import utilities.Excel_utilities;
import utilities.Faker_utilities;

public class AdminUsers_test extends Base {
	
	public AdminUsers_page adminuserpage;    //globally declare
	public Home_page homepage;

	@Test(priority=1,description="input_AdminUserDetails")
	public void input_AdminUserDetails() throws IOException {

		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");

		
		Faker_utilities fakerutilities=new Faker_utilities();           //usig FAKER  for random inputs
		String admin_username=fakerutilities.creatARandomFirstName();
		String admin_password=fakerutilities.creatARandomLastName();
	
		// login
		Login_page loginobject = new Login_page(driver);
		loginobject.enterUserName(username).enterPassword(password);
		homepage=loginobject.clickSignIn();
		boolean isloaded=loginobject.isHomePageLoaded();
		Assert.assertTrue(isloaded,"Not able to login");
		
		adminuserpage=homepage.moreinfo_AdminUser().newUser().input_AdminUserName(admin_username).input_AdminUserPassword(admin_password).userDetails_dropdown().save_Userdetails();
		
		boolean verifyalertmsg=adminuserpage.isUserInput_AlertBoxLoaded();
		Assert.assertTrue(verifyalertmsg,Constants.MANAGENEWSINPUT);

	}

	@Test(priority = 2)
	public void delete_AdminUserDetails() throws IOException {
		
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		
	
		
		// login
		Login_page loginobject = new Login_page(driver);
		loginobject.enterUserName(username).enterPassword(password);
		homepage=loginobject.clickSignIn();// fix this   // verify alert
		adminuserpage=homepage.moreinfo_AdminUser().deleteAdminUserInformation();                                      
		boolean checkAlertMsg=adminuserpage.isUserDelete_AlertBoxLoaded();
		Assert.assertTrue(checkAlertMsg,Constants.ADMINUSERDELETE);

	}

}

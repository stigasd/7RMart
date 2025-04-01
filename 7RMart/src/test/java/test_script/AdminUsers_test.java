package test_script;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsers_page;
import pages.Home_page;
import pages.Login_page;
import utilities.Excel_utilities;
import utilities.Faker_utilities;

public class AdminUsers_test extends Base {
	
	public AdminUsers_page adminuserpage;    //globally declare
	public Home_page homepagelogout;

	@Test(priority=1,description="input_AdminUserDetails")
	public void input_AdminUserDetails() throws IOException {
//
//		String username=Excel_utilities.getStringdata(1,0,"loginpage");
//		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		
		String username="admin";
		String password="admin";
		
		
//		Faker_utilities fakerutilities=new Faker_utilities();           //usig FAKER  for random inputs
//		String admin_username=fakerutilities.creatARandomFirstName();
//		String admin_password=fakerutilities.creatARandomLastName();
	
		// login
		Login_page loginobject = new Login_page(driver);
		loginobject.enterUserName(username).enterPassword(password);
		homepagelogout=loginobject.clickSignIn();
//		loginobject.enterPassword(password);
//		loginobject.clickSignIn();
		boolean isloaded=loginobject.isHomePageLoaded();
		Assert.assertTrue(isloaded,"Not able to login");
		
		//AdminUsers_page adminUserInput = new AdminUsers_page(driver);

	//	adminUserInput.moreinfo_AdminUser();
		adminuserpage=homepagelogout.moreinfo_AdminUser();
		adminuserpage.newUser().Input_AdminUserName(username).Input_AdminUserPassword(password).userDetails_dropdown().save_Userdetails();
//		adminuserpage.Input_AdminUserName(admin_username);
//		adminuserpage.Input_AdminUserPassword(admin_password);
//		adminuserpage.userDetails_dropdown();
//		adminuserpage.save_Userdetails();
		boolean verifyalertmsg=adminuserpage.isUserInput_AlertBoxLoaded();
		Assert.assertTrue(verifyalertmsg,"Alert msg not displayed");

	}

	@Test(priority = 2)
	public void delete_AdminUserDetails() throws IOException {
		
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		
	
		
		// login
		Login_page loginobject = new Login_page(driver);
		loginobject.enterUserName(username).enterPassword(password).clickSignIn();
		homepagelogout=loginobject.clickSignIn();// fix this   // verify alert
		adminuserpage=homepagelogout.moreinfo_AdminUser();                                         
		adminuserpage.deleteAdminUserInformation();
		boolean checkAlertMsg=adminuserpage.isUserDelete_AlertBoxLoaded();
		Assert.assertTrue(checkAlertMsg,"delete success msg not found");

	}

}

package test_script;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pages.AdminUsers_page;
import pages.Login_page;
import utilities.Excel_utilities;
import utilities.Faker_utilities;

public class AdminUsers_test extends Base {

	@Test(priority=1,retryAnalyzer=retry.Retry.class,description="input_AdminUserDetails")
	public void input_AdminUserDetails() throws IOException {

		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		
		
		Faker_utilities fakerutilities=new Faker_utilities();           //usig FAKER  for random inputs
		String admin_username=fakerutilities.creatARandomFirstName();
		String admin_password=fakerutilities.creatARandomLastName();
	
		// login
		Login_page loginobject = new Login_page(driver);
		loginobject.enterUserName(username);
		loginobject.enterPassword(password);
		loginobject.clickSignIn();
		loginobject.isHomePageLoaded();
		
		AdminUsers_page adminUserInput = new AdminUsers_page(driver);

		adminUserInput.moreinfo_AdminUser();
		adminUserInput.newUser();
		adminUserInput.Input_AdminUserName(admin_username);
		adminUserInput.Input_AdminUserPassword(admin_password);
		adminUserInput.userDetails_dropdown();
		adminUserInput.save_Userdetails();
		adminUserInput.isUserInput_AlertBoxLoaded();

	}

	@Test(priority = 2)
	public void delete_AdminUserDetails() throws IOException {
		
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		
	
		
		// login
		Login_page loginobject = new Login_page(driver);
		loginobject.enterUserName(username);
		loginobject.enterPassword(password);
		loginobject.clickSignIn();
		loginobject.isHomePageLoaded(); // verify alert

		AdminUsers_page adminUserdelete = new AdminUsers_page(driver);

		adminUserdelete.moreinfo_AdminUser();
		adminUserdelete.deleteAdminUserInformation();
		adminUserdelete.isUserDelete_AlertBoxLoaded();  //alert verifying
		

	}

}

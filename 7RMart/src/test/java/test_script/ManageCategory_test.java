package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.Home_page;
import pages.Login_page;
import pages.ManageCategory_page;
import utilities.Excel_utilities;

public class ManageCategory_test extends Base {
	public Home_page homepage;
	public ManageCategory_page managecategorypage;
	@Test(priority=1)
	public void enterCategoryInformation() throws IOException
	{
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		String category="drink";
		
		Login_page pagelogin=new Login_page(driver);
		pagelogin.enterUserName(username).enterPassword(password);
		homepage=pagelogin.clickSignIn();
		
		
		managecategorypage=homepage.clickMoreInfoManageCategory().clickNewButton().inputCategory_field(category).clickDiscount().uploadFile().clickSaveButton();
		boolean checkAlertMSg=managecategorypage.verifyAlert();
		Assert.assertTrue(checkAlertMSg,Constants.MANAGECATEGORYINPUT );
		
		
		
		
	}
	@Test(priority=2)
	public void categoryInformation() throws IOException
	{
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		String searchCategory="drink";
		Login_page pagelogin=new Login_page(driver);
		pagelogin.enterUserName(username).enterPassword(password);
		homepage=pagelogin.clickSignIn();
		boolean isloaded=pagelogin.isHomePageLoaded();
		Assert.assertTrue(isloaded, "login page not loaded");
		
		managecategorypage=homepage.clickMoreInfoManageCategory().clickSearchButton().inputCategoryfield(searchCategory).clickSubmitSearch().clickDeleteButton();

		boolean verifyAlert=managecategorypage.checkAlertMsg();
		Assert.assertTrue(verifyAlert,Constants.MANAGECATEGORYDELTE);
		
		
		
	}

}

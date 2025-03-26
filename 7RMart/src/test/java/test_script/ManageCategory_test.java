package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;
import pages.ManageCategory_page;
import utilities.Excel_utilities;

public class ManageCategory_test extends Base {
	@Test(priority=1)
	public void enterCategoryInformation() throws IOException
	{
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		String category="drink";
		
		Login_page pagelogin=new Login_page(driver);
		pagelogin.enterUserName(username);
		pagelogin.enterPassword(password);
		pagelogin.clickSignIn();
		boolean isloaded=pagelogin.isHomePageLoaded();
		Assert.assertTrue(isloaded, "login page not loaded");
		
		ManageCategory_page managecategorypage=new ManageCategory_page(driver);
		managecategorypage.clickMoreInfoManageCategory();
		managecategorypage.clickNewButton();
		managecategorypage.inputCategory_field(category);
		managecategorypage.clickDiscount();
		managecategorypage.uploadFile();
		
		
//		managecategorypage.clickRadioButtonTopMenu();
//		managecategorypage.clickRadioButtonLeftMenu();
		managecategorypage.clickSaveButton();
		boolean checkAlertMSg=managecategorypage.verifyAlert();
		Assert.assertTrue(checkAlertMSg,"error loading alert msg" );
		
		
		
		
	}
	@Test(priority=2)
	public void categoryInformation() throws IOException
	{
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		String searchCategory="drink";
		Login_page pagelogin=new Login_page(driver);
		pagelogin.enterUserName(username);
		pagelogin.enterPassword(password);
		pagelogin.clickSignIn();
		boolean isloaded=pagelogin.isHomePageLoaded();
		Assert.assertTrue(isloaded, "login page not loaded");
		
		ManageCategory_page managecategorypage=new ManageCategory_page(driver);
		managecategorypage.clickMoreInfoManageCategory();
		managecategorypage.clickSearchButton();
		managecategorypage.inputCategoryfield(searchCategory);
		managecategorypage.clickSubmitSearch();
		managecategorypage.clickDeleteButton();
		managecategorypage.checkAlertMsg();
		
		
		
	}

}

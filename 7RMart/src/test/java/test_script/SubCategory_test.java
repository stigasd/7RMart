package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home_page;
import pages.Login_page;
import pages.SubCategory_page;
import utilities.Excel_utilities;
import utilities.Page_utilities;

public class SubCategory_test extends Base {
	SubCategory_page subcategorypage;
	Home_page homepage;
	
	@Test(priority=1,description="adding sub category list")
	public void insertSubCategoryList() throws IOException
	{
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		String datainput=Excel_utilities.getStringdata(1,0,"subcategory");
		String pathinput=Excel_utilities.getStringdata(1,1,"subcategory");
		Login_page pagelogin=new Login_page(driver);
		pagelogin.enterUserName(username).enterPassword(password);
		homepage=pagelogin.clickSignIn();
		boolean isloaded=pagelogin.isHomePageLoaded();
		Assert.assertTrue(isloaded, "login page not loaded");
		
		subcategorypage=homepage.clickMoreInfo().clickNewButton().selectCategory().inputSubCategory_field(datainput).uploadImage().clickSaveButton();
		boolean checkAlert=subcategorypage.verifyAlertMsg();
		Assert.assertTrue(checkAlert,"error loading alertmsg");
		
		
		
	}
	
	@Test(priority=2,description="deleting sub category list")
	public void deleteSubCategoryList() throws IOException
	{
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		String datainput=Excel_utilities.getStringdata(1,0,"subcategory");
		
		Login_page pagelogin=new Login_page(driver);
		pagelogin.enterUserName(username).enterPassword(password);
		homepage=pagelogin.clickSignIn();
		boolean isloaded=pagelogin.isHomePageLoaded();
		Assert.assertTrue(isloaded, "login page not loaded");
		
		subcategorypage=homepage.clickMoreInfo().deleteSubCategory();
		boolean checkAlert=subcategorypage.verifyDeleteAlertMsg();
		Assert.assertTrue(checkAlert,"Delete success msg note found");
		
		
		
		
		
	}

}

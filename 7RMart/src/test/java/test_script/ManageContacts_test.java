package test_script;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.Home_page;
import pages.Login_page;
import pages.ManageContacts_page;
import utilities.Excel_utilities;


public class ManageContacts_test extends Base 
{   
	public Home_page homepage;
	public ManageContacts_page managecontactspage;
	@Test(description="manage contacts")
	public void manageContact() throws Exception
	{

		
		String username=Excel_utilities.getStringdata(1,0,"loginpage");
		String password= Excel_utilities.getStringdata(1,1,"loginpage");
		String phone=Excel_utilities.getIntegerdata(2,0,"managecontact");
		String email= Excel_utilities.getStringdata(2,1,"managecontact");
		String address= Excel_utilities.getStringdata(2,2,"managecontact");
		String deliveryTime= Excel_utilities.getIntegerdata(2,3,"managecontact");
		String deliveryCharge= Excel_utilities.getIntegerdata(2,4,"managecontact");
		
		Login_page login=new Login_page(driver);
		login.enterUserName(username).enterPassword(password);
		homepage=login.clickSignIn();
		managecontactspage=homepage.moreinfoManageContact().clickActionButton().enterPhoneNumber(phone).enterEmail(email).enteraddress(address).enterDeliveryTime(deliveryTime).enterDeliveryCharge(deliveryCharge).manageContactsUpdateButton();

		boolean verifyAlert=managecontactspage.isAlertLoaded();
		Assert.assertTrue(verifyAlert,Constants.MANAGECONTACTSINPUT);
		
		
		
		
		
		
	}
	
	

}

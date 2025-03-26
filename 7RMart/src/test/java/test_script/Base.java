package test_script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
	
	public WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializerbrowser(String browser) throws Exception
	{
	 if(browser.equalsIgnoreCase("chrome"))
	 {
		 driver=new ChromeDriver();
	 }
	 else if(browser.equalsIgnoreCase("edge"))
	 {
		 driver=new EdgeDriver();
	 }
	 else
	 {
		 throw new Exception("Browser is not available");
	 }
		
	 
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void quitandclose()
	{
      // driver.quit();
     //	driver.close();
	}

}

package test_script;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.Screenshot_utilities;
import utilities.Wait_utilities;

public class Base {
	public Properties properties;
	public FileInputStream fileinputstream;
	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializerbrowser(String browser) throws Exception {
		try { // file create chythe url kodukan vendi olla oru use chyunath method
			properties = new Properties();
			fileinputstream = new FileInputStream(Constants.CONFIGFILE);
			properties.load(fileinputstream);

		} catch (Exception e) {
			System.out.println("Error");
		}

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("Browser is not available");
		}

		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Wait_utilities.IMPLICIT_WAIT));
		driver.manage().window().maximize();

	}

	@AfterMethod(alwaysRun = true)

	 public void browserQuit(ITestResult iTestResult) throws IOException { 
		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
			Screenshot_utilities scrShot = new Screenshot_utilities(); 
			scrShot.getScreenShot(driver, iTestResult.getName()); 
		} 
 
	}
	public void quitandclose() {
		driver.quit();
		// driver.close();
	}

}

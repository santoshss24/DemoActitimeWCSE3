package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import library.GetPhoto;
import library.IAutoConstants;
import library.webActionUtil;
import pages.Homepage;
import pages.LoginPage;

public class BaseTest implements IAutoConstants
{
	public WebDriver driver;
	public webActionUtil webActionUtil;
	@BeforeClass
	public void launchApp()
	{
		if (BROWSER_NAME.equalsIgnoreCase("chrome")) 
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		}else if (BROWSER_NAME.equalsIgnoreCase("firefox")) {
			
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();
		}else {
			System.out.println(BROWSER_NAME+"Not supported");
		}
		driver.manage().window().maximize();
		long implicit=Long.parseLong(ITO);
		driver.manage().timeouts().implicitlyWait(implicit, TimeUnit.SECONDS);
		long explicit=Long.parseLong(ETO);
		webActionUtil =new webActionUtil(driver, explicit);
		driver.get(APP_URL);
	}
	
	@BeforeMethod
	public void loginToApp()
	{
		LoginPage login=new LoginPage(driver, webActionUtil);
		login.login(USERNAME,PASSWORD);
		
	}
	@AfterMethod
	public void logoutFromApp(ITestResult result)
	{
		if (result.getStatus()==2) {
			GetPhoto.getPhoto(driver,result.getName());
		}
		Homepage homepage=new Homepage(driver, webActionUtil);
		homepage.clickOnLogout();
	}
	
	@AfterClass(enabled = false)
	public void closeApp()
	{
		driver.quit();
	}

}

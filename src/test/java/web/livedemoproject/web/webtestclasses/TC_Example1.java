package web.livedemoproject.web.webtestclasses;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.QFUtilities;
import web.livedemoproject.web.webpageclasses.*;

public class TC_Example1 extends BaseClass { 

 	QFUtilities qf;
	private ConfigFilesUtility configFileObj;
	public boolean isElementDispalyed = false;
 	private String browserName = "chrome";
	private WebDriver driver;


	public TC_Example1() throws Exception {
		configFileObj = new ConfigFilesUtility();
		qf = new QFUtilities();
		configFileObj.loadPropertyFile("tc_example1.properties");
	}

	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		browserName = browser;
	}

	private void setup() {
		driver = launchBrowser(browserName, configFileObj);
	}

	private void screen1Test(int i) throws Exception {

		Screen1 screen1Obj = new Screen1();
		try { 
			qf.clickAction(driver, screen1Obj._adskeprivacypagelogo);
			printSuccessLogAndReport( "Clicked on adsk-eprivacy-page-logo");
			qf.clickAction(driver, screen1Obj._adskeprivacyconfirmexitlogo);
			printSuccessLogAndReport( "Clicked on adsk-eprivacy-confirm-exit-logo");
			qf.clickAction(driver, screen1Obj._adskeprivacyconfirmexitdialog);
			printSuccessLogAndReport( "Clicked on adsk-eprivacy-confirm-exit-dialog");

		} catch (Exception e) {
			isElementDispalyed = false;
			printFailureLogAndReport(   "Element is not found" + e.getLocalizedMessage());
		} finally {
			cleanupObject(screen1Obj);
		}
	}

	@Test
	public void screensTest() throws Exception {
		for(int datasets = 1; datasets <= configFileObj.getIntProperty("datasetsLength"); datasets++) {
			isElementDispalyed = true;		 
			setup();			
			setTestcaseName(browserName,"TC_Example1 - " + configFileObj.getProperty("dataset" + (datasets)));
			if(isElementDispalyed) {screen1Test(datasets);}
			tearDown();
		}	}

	
	public void tearDown() throws Exception {
		driver.quit();
		driver=null;
	}
	
	@AfterTest
	private void cleanup() {
		configFileObj =  null;
		qf = null;
		System.runFinalization();
	}

}
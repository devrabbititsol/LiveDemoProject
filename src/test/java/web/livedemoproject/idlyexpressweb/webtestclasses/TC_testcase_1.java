package web.livedemoproject.idlyexpressweb.webtestclasses;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.QFUtilities;
import web.livedemoproject.idlyexpressweb.webpageclasses.*;

public class TC_testcase_1 extends BaseClass { 

 	QFUtilities qf;
	private ConfigFilesUtility configFileObj;
	public boolean isElementDispalyed = false;
 	private String browserName = "chrome";
	private WebDriver driver;


	public TC_testcase_1() throws Exception {
		configFileObj = new ConfigFilesUtility();
		qf = new QFUtilities();
		configFileObj.loadPropertyFile("tc_testcase_1.properties");
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
			qf.clickAction(driver, screen1Obj._storesetup, configFileObj.getBooleanProperty("storesetup1"  + i + "click"));
			if(configFileObj.getBooleanProperty("storesetup1"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Store setup");
			qf.sendKeys(driver, screen1Obj._enterStoreName, configFileObj.getProperty("enterStoreName1"  + i + "input"));
			printSuccessLogAndReport( "Entered Enter Store Name input: " + configFileObj.getProperty("enterStoreName1"  + i + "input"));
			qf.sendKeys(driver, screen1Obj._enterYourDescription, configFileObj.getProperty("enterYourDescription1"  + i + "input"));
			printSuccessLogAndReport( "Entered Enter Your Description input: " + configFileObj.getProperty("enterYourDescription1"  + i + "input"));
			qf.sendKeys(driver, screen1Obj._enterPhoneNumber, configFileObj.getProperty("enterPhoneNumber1"  + i + "input"));
			printSuccessLogAndReport( "Entered Enter Phone Number input: " + configFileObj.getProperty("enterPhoneNumber1"  + i + "input"));
			qf.sendKeys(driver, screen1Obj._enterEmailAddress, configFileObj.getProperty("enterEmailAddress1"  + i + "input"));
			printSuccessLogAndReport( "Entered Enter Email Address input: " + configFileObj.getProperty("enterEmailAddress1"  + i + "input"));
			qf.sendKeys(driver, screen1Obj._enterYourAddress, configFileObj.getProperty("enterYourAddress1"  + i + "input"));
			printSuccessLogAndReport( "Entered Enter Your Address input: " + configFileObj.getProperty("enterYourAddress1"  + i + "input"));
			qf.clickAction(driver, screen1Obj._sAVE, configFileObj.getBooleanProperty("sAVE1"  + i + "click"));
			if(configFileObj.getBooleanProperty("sAVE1"  + i + "click"))
			printSuccessLogAndReport( "Clicked on SAVE");

		} catch (Exception e) {
			isElementDispalyed = false;
			printFailureLogAndReport(   "Element is not found" + e.getLocalizedMessage());
		} finally {
			cleanupObject(screen1Obj);
		}
	}

	private void dashboardScreenTest(int i) throws Exception {

		DashboardScreen dashboardScreenObj = new DashboardScreen();
		try { 
			qf.clickAction(driver, dashboardScreenObj._onlinestore, configFileObj.getBooleanProperty("onlinestore2"  + i + "click"));
			if(configFileObj.getBooleanProperty("onlinestore2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Online store");

		} catch (Exception e) {
			isElementDispalyed = false;
			printFailureLogAndReport(   "Element is not found" + e.getLocalizedMessage());
		} finally {
			cleanupObject(dashboardScreenObj);
		}
	}

	@Test
	public void screensTest() throws Exception {
		for(int datasets = 1; datasets <= configFileObj.getIntProperty("datasetsLength"); datasets++) {
			isElementDispalyed = true;		 
			setup();			
			setTestcaseName(browserName,"TC_testcase_1 - " + configFileObj.getProperty("dataset" + (datasets)));
			if(isElementDispalyed) {screen1Test(datasets);}
			if(isElementDispalyed) {dashboardScreenTest(datasets);}
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
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

public class TC_settings_testCase extends BaseClass { 

 	QFUtilities qf;
	private ConfigFilesUtility configFileObj;
	public boolean isElementDispalyed = false;
 	private String browserName = "chrome";
	private WebDriver driver;


	public TC_settings_testCase() throws Exception {
		configFileObj = new ConfigFilesUtility();
		qf = new QFUtilities();
		configFileObj.loadPropertyFile("tc_settings_testcase.properties");
	}

	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		browserName = browser;
	}

	private void setup() {
		driver = launchBrowser(browserName, configFileObj);
	}

	private void dashboardScreenTest(int i) throws Exception {

		DashboardScreen dashboardScreenObj = new DashboardScreen();
		try { 
			qf.clickAction(driver, dashboardScreenObj._settings, configFileObj.getBooleanProperty("settings1"  + i + "click"));
			if(configFileObj.getBooleanProperty("settings1"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Settings");
			qf.clickAction(driver, dashboardScreenObj._orders, configFileObj.getBooleanProperty("orders1"  + i + "click"));
			if(configFileObj.getBooleanProperty("orders1"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Orders");
			qf.clickAction(driver, dashboardScreenObj._onlinestore, configFileObj.getBooleanProperty("onlinestore1"  + i + "click"));
			if(configFileObj.getBooleanProperty("onlinestore1"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Online store");

		} catch (Exception e) {
			isElementDispalyed = false;
			printFailureLogAndReport(   "Element is not found" + e.getLocalizedMessage());
		} finally {
			cleanupObject(dashboardScreenObj);
		}
	}

	private void settingsscreenTest(int i) throws Exception {

		Settings_screen settingsscreenObj = new Settings_screen();
		try { 
			qf.clickAction(driver, settingsscreenObj._storesettingssellproductsonline, configFileObj.getBooleanProperty("storesettingssellproductsonline2"  + i + "click"));
			if(configFileObj.getBooleanProperty("storesettingssellproductsonline2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on store_settings_sell_products_online");
			qf.clickAction(driver, settingsscreenObj._storesettingsrewards, configFileObj.getBooleanProperty("storesettingsrewards2"  + i + "click"));
			if(configFileObj.getBooleanProperty("storesettingsrewards2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on store_settings_rewards");
			qf.clickAction(driver, settingsscreenObj._storesettingsproductprice, configFileObj.getBooleanProperty("storesettingsproductprice2"  + i + "click"));
			if(configFileObj.getBooleanProperty("storesettingsproductprice2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on store_settings_product_price");
			qf.clickAction(driver, settingsscreenObj._storesettingsproductavailability, configFileObj.getBooleanProperty("storesettingsproductavailability2"  + i + "click"));
			if(configFileObj.getBooleanProperty("storesettingsproductavailability2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on store_settings_product_availability");
			qf.clickAction(driver, settingsscreenObj._storesettingscashondelivery, configFileObj.getBooleanProperty("storesettingscashondelivery2"  + i + "click"));
			if(configFileObj.getBooleanProperty("storesettingscashondelivery2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on store_settings_cash_on_delivery");

		} catch (Exception e) {
			isElementDispalyed = false;
			printFailureLogAndReport(   "Element is not found" + e.getLocalizedMessage());
		} finally {
			cleanupObject(settingsscreenObj);
		}
	}

	@Test
	public void screensTest() throws Exception {
		for(int datasets = 1; datasets <= configFileObj.getIntProperty("datasetsLength"); datasets++) {
			isElementDispalyed = true;		 
			setup();			
			setTestcaseName(browserName,"TC_settings_testCase - " + configFileObj.getProperty("dataset" + (datasets)));
			if(isElementDispalyed) {dashboardScreenTest(datasets);}
			if(isElementDispalyed) {settingsscreenTest(datasets);}
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
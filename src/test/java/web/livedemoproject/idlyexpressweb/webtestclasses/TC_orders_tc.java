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

public class TC_orders_tc extends BaseClass { 

 	QFUtilities qf;
	private ConfigFilesUtility configFileObj;
	public boolean isElementDispalyed = false;
 	private String browserName = "chrome";
	private WebDriver driver;


	public TC_orders_tc() throws Exception {
		configFileObj = new ConfigFilesUtility();
		qf = new QFUtilities();
		configFileObj.loadPropertyFile("tc_orders_tc.properties");
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

	private void ordersscreenTest(int i) throws Exception {

		Orders_screen ordersscreenObj = new Orders_screen();
		try { 
			qf.clickAction(driver, ordersscreenObj._rejected, configFileObj.getBooleanProperty("rejected2"  + i + "click"));
			if(configFileObj.getBooleanProperty("rejected2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Rejected ()");
			qf.clickAction(driver, ordersscreenObj._readyforDelivery, configFileObj.getBooleanProperty("readyforDelivery2"  + i + "click"));
			if(configFileObj.getBooleanProperty("readyforDelivery2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Ready for Delivery ()");
			qf.clickAction(driver, ordersscreenObj._liveOrders, configFileObj.getBooleanProperty("liveOrders2"  + i + "click"));
			if(configFileObj.getBooleanProperty("liveOrders2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Live Orders ()");
			qf.clickAction(driver, ordersscreenObj._inProcess, configFileObj.getBooleanProperty("inProcess2"  + i + "click"));
			if(configFileObj.getBooleanProperty("inProcess2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on In Process ()");
			qf.clickAction(driver, ordersscreenObj._futureOrders, configFileObj.getBooleanProperty("futureOrders2"  + i + "click"));
			if(configFileObj.getBooleanProperty("futureOrders2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Future Orders ()");
			qf.clickAction(driver, ordersscreenObj._allOrders, configFileObj.getBooleanProperty("allOrders2"  + i + "click"));
			if(configFileObj.getBooleanProperty("allOrders2"  + i + "click"))
			printSuccessLogAndReport( "Clicked on All Orders ()");

		} catch (Exception e) {
			isElementDispalyed = false;
			printFailureLogAndReport(   "Element is not found" + e.getLocalizedMessage());
		} finally {
			cleanupObject(ordersscreenObj);
		}
	}

	@Test
	public void screensTest() throws Exception {
		for(int datasets = 1; datasets <= configFileObj.getIntProperty("datasetsLength"); datasets++) {
			isElementDispalyed = true;		 
			setup();			
			setTestcaseName(browserName,"TC_orders_tc - " + configFileObj.getProperty("dataset" + (datasets)));
			if(isElementDispalyed) {dashboardScreenTest(datasets);}
			if(isElementDispalyed) {ordersscreenTest(datasets);}
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
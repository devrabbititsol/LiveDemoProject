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

public class TC_OrderIdlyTestcase extends BaseClass { 

 	QFUtilities qf;
	private ConfigFilesUtility configFileObj;
	public boolean isElementDispalyed = false;
 	private String browserName = "chrome";
	private WebDriver driver;


	public TC_OrderIdlyTestcase() throws Exception {
		configFileObj = new ConfigFilesUtility();
		qf = new QFUtilities();
		configFileObj.loadPropertyFile("tc_orderidlytestcase.properties");
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

	private void orderConfirmedScreenTest(int i) throws Exception {

		OrderConfirmedScreen orderConfirmedScreenObj = new OrderConfirmedScreen();
		try { 
			windowHandle(driver);
						qf.clickAction(driver, orderConfirmedScreenObj._yourorderhasbeenplacedsuccessfully);
			printSuccessLogAndReport( "Clicked on Your order has been placed successfully");

		} catch (Exception e) {
			isElementDispalyed = false;
			printFailureLogAndReport(   "Element is not found" + e.getLocalizedMessage());
		} finally {
			cleanupObject(orderConfirmedScreenObj);
		}
	}

	private void idlySelectionTest(int i) throws Exception {

		IdlySelection idlySelectionObj = new IdlySelection();
		try { 
			windowHandle(driver);
						qf.wait(driver, idlySelectionObj._close);
			qf.clickAction(driver, idlySelectionObj._close);
			printSuccessLogAndReport( "Clicked on Close");
			windowHandle(driver);
						windowHandle(driver);
						windowHandle(driver);
						qf.clickAction(driver, idlySelectionObj._idlyV, configFileObj.getBooleanProperty("idlyV3"  + i + "click"));
			if(configFileObj.getBooleanProperty("idlyV3"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Idly (V)");
			windowHandle(driver);
						qf.clickAction(driver, idlySelectionObj._addtoCart, configFileObj.getBooleanProperty("addtoCart3"  + i + "click"));
			if(configFileObj.getBooleanProperty("addtoCart3"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Add to Cart");

		} catch (Exception e) {
			isElementDispalyed = false;
			printFailureLogAndReport(   "Element is not found" + e.getLocalizedMessage());
		} finally {
			cleanupObject(idlySelectionObj);
		}
	}

	private void podiIdlySelectionTest(int i) throws Exception {

		PodiIdlySelection podiIdlySelectionObj = new PodiIdlySelection();
		try { 
			windowHandle(driver);
						qf.clickAction(driver, podiIdlySelectionObj._podiIdlyV, configFileObj.getBooleanProperty("podiIdlyV4"  + i + "click"));
			if(configFileObj.getBooleanProperty("podiIdlyV4"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Podi Idly (V)");
			windowHandle(driver);
						windowHandle(driver);
						qf.clickAction(driver, podiIdlySelectionObj._addtoCart, configFileObj.getBooleanProperty("addtoCart4"  + i + "click"));
			if(configFileObj.getBooleanProperty("addtoCart4"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Add to Cart");
			windowHandle(driver);
						qf.clickAction(driver, podiIdlySelectionObj._checkout0, configFileObj.getBooleanProperty("checkout04"  + i + "click"));
			if(configFileObj.getBooleanProperty("checkout04"  + i + "click"))
			printSuccessLogAndReport( "Clicked on Checkout (0)");

		} catch (Exception e) {
			isElementDispalyed = false;
			printFailureLogAndReport(   "Element is not found" + e.getLocalizedMessage());
		} finally {
			cleanupObject(podiIdlySelectionObj);
		}
	}

	private void checkoutScreenTest(int i) throws Exception {

		CheckoutScreen checkoutScreenObj = new CheckoutScreen();
		try { 
			windowHandle(driver);
						qf.sendKeys(driver, checkoutScreenObj._yourfirstnamehere, configFileObj.getProperty("yourfirstnamehere5"  + i + "input"));
			printSuccessLogAndReport( "Entered Your first name here input: " + configFileObj.getProperty("yourfirstnamehere5"  + i + "input"));
			windowHandle(driver);
						qf.sendKeys(driver, checkoutScreenObj._yourlastnamehere, configFileObj.getProperty("yourlastnamehere5"  + i + "input"));
			printSuccessLogAndReport( "Entered Your last name here input: " + configFileObj.getProperty("yourlastnamehere5"  + i + "input"));
			windowHandle(driver);
						qf.sendKeys(driver, checkoutScreenObj._youremailhere, configFileObj.getProperty("youremailhere5"  + i + "input"));
			printSuccessLogAndReport( "Entered Your email here input: " + configFileObj.getProperty("youremailhere5"  + i + "input"));
			windowHandle(driver);
						qf.sendKeys(driver, checkoutScreenObj._yourphonenumberhere, configFileObj.getProperty("yourphonenumberhere5"  + i + "input"));
			printSuccessLogAndReport( "Entered Your phone number here input: " + configFileObj.getProperty("yourphonenumberhere5"  + i + "input"));
			windowHandle(driver);
						qf.clickAction(driver, checkoutScreenObj._cOD);
			printSuccessLogAndReport( "Clicked on COD");
			windowHandle(driver);
						qf.clickAction(driver, checkoutScreenObj._cONTINUE, configFileObj.getBooleanProperty("cONTINUE5"  + i + "click"));
			if(configFileObj.getBooleanProperty("cONTINUE5"  + i + "click"))
			printSuccessLogAndReport( "Clicked on CONTINUE");

		} catch (Exception e) {
			isElementDispalyed = false;
			printFailureLogAndReport(   "Element is not found" + e.getLocalizedMessage());
		} finally {
			cleanupObject(checkoutScreenObj);
		}
	}

	@Test
	public void screensTest() throws Exception {
		for(int datasets = 1; datasets <= configFileObj.getIntProperty("datasetsLength"); datasets++) {
			isElementDispalyed = true;		 
			setup();			
			setTestcaseName(browserName,"TC_OrderIdlyTestcase - " + configFileObj.getProperty("dataset" + (datasets)));
			if(isElementDispalyed) {dashboardScreenTest(datasets);}
			if(isElementDispalyed) {orderConfirmedScreenTest(datasets);}
			if(isElementDispalyed) {idlySelectionTest(datasets);}
			if(isElementDispalyed) {podiIdlySelectionTest(datasets);}
			if(isElementDispalyed) {checkoutScreenTest(datasets);}
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
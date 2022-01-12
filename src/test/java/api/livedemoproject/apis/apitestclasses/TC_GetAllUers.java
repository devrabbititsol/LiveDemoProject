package api.livedemoproject.apis.apitestclasses;

import com.restassured.services.*;
import org.testng.annotations.Test;
import com.utilities.BaseClass;
import com.utilities.QFCustomizedCode;
import com.utilities.ConfigFilesUtility;
import api.livedemoproject.apis.apipageclasses.GetSingleUserDataset;
public class TC_GetAllUers extends BaseClass {
	private ConfigFilesUtility configFileObj;

	public TC_GetAllUers() throws Exception {
		configFileObj= new ConfigFilesUtility();
		configFileObj.loadPropertyFile("TC_GetAllUers.properties");
	}

	@Test(priority = 1)
	public void doRequest() throws Exception { 
	
		for(int i = 1; i <= configFileObj.getIntProperty("datasetsLength"); i++) {
			boolean isExecutionFlag = true;			
		/*--------------------- GET --------------------- */

			if(isExecutionFlag) {
 			 	Object object = (Object) new GetSingleUserDataset();
				Class<?> c = object.getClass();
				String urlParams = (String) c.getField("urlParams" + i).get(object);
				if(urlParams == null) return;
				String headers = (String) c.getField("headers" + i).get(object);
				String body = (String) c.getField("body" + i).get(object);
				String authenticationData = (String) c.getField("authenticationData" + i).get(object);
				String apiName = (String) c.getField("apiName" + i).get(object);
				String datasetResources = (String) c.getField("datasetResources" + i).get(object);
				int reqType = (Integer) c.getField("requestType" + i).get(object);
				int bodyType = (Integer) c.getField("bodyType" + i).get(object);
				String header = (String) c.getField("datasetHeader" + i).get(object);
				String response = APIService.callRequest(configFileObj,apiName, urlParams, headers, reqType, bodyType, body, configFileObj.getProperty("dataset" +i), datasetResources, authenticationData, formurlEncodedData, formData, linkParams,statusParams);
				QFCustomizedCode.customCode(apiName, body, response,"livedemoproject");
			}
		}
	}}

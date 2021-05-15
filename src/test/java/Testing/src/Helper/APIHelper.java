package Testing.src.Helper;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import Testing.src.Helper.APIProperties.APIName;
import Testing.src.Helper.APIProperties.APIReponseStatus;
import Testing.src.Helper.APIProperties.APIRequestType;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelper {

	private String url;
	private Object parameters;
	private APIRequestType requestType;
	private HashMap<String,String> headers;
	private ContentType contentType;
	private File file;
	
	public APIHelper(APIName apiName , Object parameters, HashMap<String,String> headers, APIRequestType requestType,ContentType contentType,File file){
		this.parameters = parameters;
		this.url = urlBuilder(apiName);
		this.requestType = requestType;
		this.headers = headers;
		this.contentType = contentType;
		this.file = file;
	}
	
	public Response execute()
	{
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(contentType);
		if(contentType == ContentType.URLENC)
			url = url + parameters.toString();
		else
			reqspec.body(parameters);		
		if(headers !=null)
			reqspec.headers(headers);
		if (file !=null)
			reqspec.multiPart(file);
		reqspec.log().all();
		Response response = null;
		switch(requestType)
		{
		case GET:
			response = reqspec.get(url);
			break;
		case POST:
			response = reqspec.post(url);
			break;
		default:
			System.out.println("Request Type " + requestType.toString() + " is not defined");			
		}
		response.then().log().all();
		System.out.println("API Executed in :" + response.getTimeIn(TimeUnit.MILLISECONDS) + " ms");
		return response;
	}
	
	public void verifyReponse(Response response,APIReponseStatus reponseStatus, String responseString,ContentType contentType)
	{
		Assert.assertEquals(reponseStatus.getAPIReponseCode(), response.getStatusCode());
		Assert.assertEquals(responseString, response.getStatusLine());
		Assert.assertEquals (contentType, response.getContentType());		
	}
	
	private String urlBuilder(APIName apiName)
	{		
		return Config.getProperties("APIBaseUrl") + apiName.getPath();		
	}
	
}

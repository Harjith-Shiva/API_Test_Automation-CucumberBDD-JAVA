package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req == null)
		{
		PrintStream log = new PrintStream("logs.txt");
		
		req = new RequestSpecBuilder().setBaseUri(getGlobalvalues("baseUrl")).addQueryParam("key","qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		
		return req;
	}
		return req;
	}
	
	public String getJsonPath(Response response, String key)
	{
		JsonPath js = new JsonPath(response.asString());
		
		return js.get(key).toString();
		
		
	}
	
	public static String getGlobalvalues(String key) throws IOException
	{
		
		
			
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Harji\\eclipse-workspace-API_Automation\\End-to-End-API-tests\\src\\test\\java\\resources\\global.properties");
		property.load(file);
		
		return property.getProperty(key);
		
		
	}
	
	
}

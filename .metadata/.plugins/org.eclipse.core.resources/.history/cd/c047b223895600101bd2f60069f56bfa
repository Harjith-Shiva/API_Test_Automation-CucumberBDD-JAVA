package mapsStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.junit.Assert;

import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class mapsStepDefinition extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	static Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;
	
	
	@Given("Add Place Payload with {string}  {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		 res=given().spec(requestSpecification())
					.body(data.addPlacePayLoad(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
		
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(httpMethod.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(httpMethod.equalsIgnoreCase("GET"))
			 response =res.when().get(resourceAPI.getResource());
		else if(httpMethod.equalsIgnoreCase("PUT"))
			response = res.when().put(resourceAPI.getResource());
		else if(httpMethod.equalsIgnoreCase("DELETE"))
			response = res.when().delete(resourceAPI.getResource());
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer expectedStatusCode) {
		
		Assert.assertEquals(response.getStatusCode(),expectedStatusCode.intValue());
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
		
		
		Assert.assertEquals(getJsonPath(response,keyValue),Expectedvalue);
		
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedNameInResponseBody, String resourceName) throws IOException {
	    
		place_id = getJsonPath(response,"place_id");
		res =given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resourceName,"GET");
		
		Assert.assertEquals(expectedNameInResponseBody,getJsonPath(response,"name"));
		
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    
		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}


	@Given("Update place payload with the new {string}")
	public void update_place_payload_with_the_new(String new_address) throws IOException {
	    res = given().spec(requestSpecification()).queryParam("place_id", place_id).body(data.updatePlacePayload(new_address,place_id));       
	}
	@Then("verify address updated maps to {string} using {string}")
	public void verify_address_updated_maps_to_using(String expectedAddressInResponseBody, String resourceName) throws IOException {
		
		
		
		res =given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resourceName,"GET");
		
		Assert.assertEquals(expectedAddressInResponseBody,getJsonPath(response,"address"));
	}
	
	@Then("after deleting the place verify that the {string} is obtained using {string}")
	public void after_deleting_the_place_verify_that_the_is_obtained_using(String expectedDeletedMessageInResponseBody, String resourceName) throws IOException {
		
		res =given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resourceName,"GET");
		
		Assert.assertEquals(expectedDeletedMessageInResponseBody,getJsonPath(response,"msg"));
	}



	
	
	
	
	
}

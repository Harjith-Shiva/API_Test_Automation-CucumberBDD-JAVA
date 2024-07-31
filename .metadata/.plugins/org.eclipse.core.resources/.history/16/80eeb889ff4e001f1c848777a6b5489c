

Feature: End-to-End Validation of Google Maps APIs


@AddPlace @UpdatePlace @Regression
Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
	Given Add Place Payload with "<name>"  "<language>" "<address>"
	When user calls "addPlaceAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
	
	
Examples:
	|name 	             | language |address		       |
	|Harjiths Home       |  Tamil   |Tiruchirappalli   |




@UpdatePlace @Regression
Scenario Outline: Validating whether the address can be successfully changed by update place API
    Given Update place payload with the new "<new_address>"
    When user calls "updatePlaceAPI" with "PUT" http request
    Then the API call got success with status code 200
    And "msg" in response body is "Address successfully updated"
    And verify address updated maps to "<new_address>" using "getPlaceAPI"
	  
    
Examples:
|new_address                   |
|Bhelpur sixth cross           |



@DeletePlace @Regression
Scenario Outline: Verify if Delete Place functionality is working

	Given DeletePlace Payload
	When user calls "deletePlaceAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And after deleting the place verify that the "<delete_message>" is obtained using "getPlaceAPI"
	And the API call got success with status code 404


Examples:
|delete_message| 
|Get operation failed, looks like place_id  doesn't exists|
	
	
	
	
	
	
	
	
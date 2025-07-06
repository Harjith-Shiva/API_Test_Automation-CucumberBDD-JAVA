package mapsStepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		
		
		mapsStepDefinition s = new mapsStepDefinition();
		if(mapsStepDefinition.place_id==null)
		{
		s.add_place_payload_with("Harjith", "Tamil", "Trichy");
		s.user_calls_with_http_request("addPlaceAPI","POST" );
		s.verify_place_id_created_maps_to_using("Harjith", "getPlaceAPI");
	    }
	}

	
	
}

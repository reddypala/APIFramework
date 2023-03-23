package stepdefinitions;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void beforeScenario() throws Exception {
		// write a code to get place id
		
		if(steps.place_id==null) {
			
		steps st = new steps();
		st.add_place_payload_with("jordam","french", "wall street");
		st.user_calls_with_http_request("AddPlaceAPI", "post");
		st.verify_place_id_created_maps_to_using("jordam", "getPlaceAPI");
		
		}
	}

}

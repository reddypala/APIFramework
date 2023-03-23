package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

public class steps extends Utils {
	RequestSpecification reqSpec;
	RequestSpecification request;
	ResponseSpecification resSpec;
	Response response;
	static String place_id;
	TestDataBuild data = new TestDataBuild();;

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws Exception {

		request = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
		// constructor will be called with the value of resource which we pass
		ApiResources resourceApi = ApiResources.valueOf(resource);
		System.out.println(resourceApi.getResource());

		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (httpMethod.equalsIgnoreCase("post")) {
			response = request.when().post(resourceApi.getResource());
		} else if (httpMethod.equalsIgnoreCase("get")) {
			response = request.when().get(resourceApi.getResource());
		}

	}

	@Then("the api call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);

	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {

		assertEquals(getJsonPath(response, keyValue), ExpectedValue);
	}

	@Then("verify placeId created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expected_Name, String resource) throws Exception {

		// prepare requestSpecification
		place_id = getJsonPath(response, "place_id");
		request = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "get");
		String actual_name = getJsonPath(response, "name");
		assertEquals(actual_name, expected_Name);

	}

	@Given("DeletePlace payload") 
	public void delete_place_payload() throws Exception {
		
	 request= given().spec(requestSpecification()).body(deletePlacePayload(place_id));
	  
	}

}

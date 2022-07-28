package stepDefinitions;



import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.jayway.jsonpath.JsonPath;

import io.cucumber.core.api.Scenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import requestBuilder.UserRequestBuilder;
import utils.FunctionLibrary;
import static io.restassured.RestAssured.given;

public class UserAPISteps extends FunctionLibrary {
	String requestData;
	Response postResponse;
	Response getResponse;
	String recordID;
	Scenario scenario;
	
	@Before
	public void setUp(Scenario scenario){
		 this.scenario=scenario;
	}
	
	@Given("User create json request data")
	public void user_create_json_request_data(DataTable  table) {
		 List<Map<String, String>> reqData = table.asMaps(String.class, String.class);
		 
		 UserRequestBuilder reqBuilder=new UserRequestBuilder();
			 reqBuilder.setCreatedAt(Long.parseLong( reqData.get(0).get("createdAt")));
			 reqBuilder.setEmployee_firstname(reqData.get(0).get("employee_firstname"));
			 reqBuilder.setEmployee_lastname(reqData.get(0).get("employee_lastname"));
			 reqBuilder.setEmployee_phonenumbe(reqData.get(0).get("employee_phonenumbe"));
			 reqBuilder.setAdemployee_emaildress(reqData.get(0).get("ademployee_emaildress"));
			 reqBuilder.setCitemployee_addressy(reqData.get(0).get("citemployee_addressy"));
			 reqBuilder.setStateemployee_dev_level(reqData.get(0).get("stateemployee_dev_level"));
			 reqBuilder.setEmployee_gender(reqData.get(0).get("employee_gender"));
			 reqBuilder.setEmployee_hire_date(reqData.get(0).get("employee_hire_date"));
			 reqBuilder.setEmployee_onleave(Boolean.parseBoolean(reqData.get(0).get("employee_onleave")));
		
		// convert object to string
			 requestData=convertObjectToString(reqBuilder);
		// write request data to cucumber report
			 scenario.write(requestData);


	}

	@When("User submit POST request")
	public void user_submit_POST_request() {
	postResponse=given()
				 	.contentType(ContentType.JSON)
				 	.body(requestData)
				 .when()
				 	 .post(property.getProperty("URL"));
	// write response to cucumber report	 
	scenario.write(postResponse.asPrettyString());

	}

	@Then("User validate statusCode is {int}")
	public void user_validate_statusCode_is(int statusCode) {
	     Assert.assertEquals(statusCode, postResponse.getStatusCode());
	}
	
	@Then("User retrives recordID from response")
	public void user_retrives_recordID_from_response() {
		recordID=JsonPath.read(postResponse.asString(), "$.id");
		scenario.write("Record ID: "+recordID);
	}

	@Then("User submits GET request with record ID")
	public void user_submits_GET_request_with_record_ID() {
		getResponse=given().when().get(property.getProperty("URL")+"/"+recordID);
		// write response to cucumber report
		scenario.write(getResponse.asPrettyString());
		// assert status code
		Assert.assertEquals(200, getResponse.getStatusCode());
	}

	@Then("User validates if user is created and exist")
	public void user_validates_if_user_is_created_and_exist() {
		Assert.assertNotNull(getResponse);
		String getRecordID=JsonPath.read(getResponse.asString(), "$.id");		
		Assert.assertEquals(recordID, getRecordID);
	}
	
	
	@Then("User delete the record")
	public void user_delete_the_record() {
		Response deleteResp=given().when().delete(property.getProperty("URL")+"/"+recordID);
		Assert.assertEquals(200, deleteResp.getStatusCode());
	}


}

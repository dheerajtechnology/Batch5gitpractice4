package StepDefinition;

import Utilities.FetchDataFromProperty;
import Utilities.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import static io.restassured.RestAssured.*;

import org.testng.Assert;

import POJOMapper.CreatingUser;

public class StepDefinitionClass {
	
	RequestSpecification req;
	RequestSpecification res;
	ResponseSpecification respec;
	Response response;
	String URL_Value=FetchDataFromProperty.readDataFromProperty().getProperty("baseURI");
	String URL_Value2=FetchDataFromProperty.readDataFromProperty().getProperty("baseURI2");
	String auth_token=FetchDataFromProperty.readDataFromProperty().getProperty("token");
			
	
	
	@Given("user should enter the URL")
	public void user_should_enter_the_url() {
		//here
		req=new RequestSpecBuilder().setBaseUri(URL_Value).setContentType(ContentType.JSON).build();
	    
	}

	@And("User will pass the payload with all details")
	public void user_will_pass_the_payload_with_all_details() {
		
		res=given().log().all().relaxedHTTPSValidation().spec(req).body(CreatingUser.createUser());	    
	}

	@When("User hit the specific {string}")
	public void user_hit_the_specific(String end_point) {
		//here the code
		respec=new ResponseSpecBuilder().expectStatusCode(200).build();
		response=res.when().post(end_point).then().log().all().spec(respec).extract().response();
    
	}

	@Then("we are going to validate the specific {string}")
	public void we_are_going_to_validate_the_specific(String status_code) {
		String s=status_code;
		int status_code_original=Integer.parseInt(s);
		int status_code_actual=response.getStatusCode();
		Assert.assertEquals(status_code_original, status_code_actual);
			    
	}
	
//		@Given("User will pass the payload with authentication details")
//public void user_will_pass_the_payload_with_authentication_detail() {
//	    res=given().log().all().header("Authorization",auth_token).relaxedHTTPSValidation().spec(req)
//	    		.body(TestData.payLoadData());
//}
//
//	@When("user will hit the  endpoint of the API as {string}")
//	public void user_will_hit_the_endpoint_of_the_api_as(String endpoint) {
//	    respec=new ResponseSpecBuilder().expectStatusCode(201).build();
//	    response=res.when().post(endpoint).then().log().all().spec(respec).extract().response();	
//	    		}
//	@Then("we are going to validate as the specific {string}")
//	public void we_are_going_to_validate_as_the_specific(String status_code) {
//		String s=status_code;
//		int status_code_original=Integer.parseInt(s);
//		int status_code_actual=response.getStatusCode();
//		Assert.assertEquals(status_code_original, status_code_actual);
//	    
//	}
//
//
//



}

package com.bhf.automation.stepDefinitions;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPIData {


	@When("^User hits the service URI and sends the request$")
	public void user_hits_the_service_URI() throws Throwable {

		RestAssured.baseURI = "https://bhf-test.apimanagement.us2.hana.ondemand.com/BHFCustomer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("EiamIdReq", "24FA9C8E43014E8A8D97E4265B8959E6");
		request.body(requestParams.toJSONString());
		Response response = request.post("/getUserInfo");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

}


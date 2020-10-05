package com.bhf.automation.stepDefinitions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestingAPI {
	
	@Test
    public void testApi() {
	Response resp = RestAssured.
	given()
	.formParam("client_id", "wbhdKibPcnAFCIr6ujGmhCt8sU8xjKbG")
	.formParam("client_secret", "tzmCYMptTZHR40Of")
	.formParam("grant_type", "client_credentials")
	.post("https://bhf-test.apimanagement.us2.hana.ondemand.com/v1/OAuthServiceCC/GenerateToken");
	
	String token=resp.jsonPath().prettify();
	
	String payload = "6UkEhtyU37uiXg3EZUVA9MNQM6qxYBi14fZ3YLEexeuMA5srOApqyXmAhq+5tLdQ/9mzBHSbxIwMrCB6LcsgtYc=";
	
	Response resp1 = RestAssured.
			given()
			.auth()
			.oauth2(token)
			.body(payload)
			.post("https://bhf-test.apimanagement.us2.hana.ondemand.com/BHFCustomer/getUserInfo");
}
}

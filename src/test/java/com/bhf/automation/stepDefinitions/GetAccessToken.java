package com.bhf.automation.stepDefinitions;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAccessToken {

	@Test
	public void getToken() {

		String oauth_token = RestAssured.given().auth().none()

				.queryParams("client_id", "wbhdKibPcnAFCIr6ujGmhCt8sU8xjKbG")
				.queryParams("client_secret", "tzmCYMptTZHR40Of")
				.queryParams("grant_type", "client_credentials")
				.when().get("https://bhf-test.apimanagement.us2.hana.ondemand.com:443/v1/OAuthServiceCC/GenerateToken")
				.then()
				.statusCode(200)
				.extract().header("access_token");

		System.out.print(oauth_token);
	}


}


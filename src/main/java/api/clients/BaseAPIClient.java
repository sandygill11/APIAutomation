package api.clients;

import api.utils.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPIClient {

	protected static String uri = ConfigManager.getConfigValue("url");
	protected static RequestSpecification requestSpec;

	static {
		RestAssured.baseURI = uri;
		requestSpec = RestAssured.given().header("Content-Type", "application/json");
	}

	public static RequestSpecification getRequestSpec() {
		return requestSpec;
	}

	public static Response sendGetRequest(String endPoint) {
		return requestSpec.when().get(endPoint).then().extract().response();
	}

	public static Response sendPostRequest(String endPoint, Object requestBody) {
		return RestAssured.given().spec(requestSpec).body(requestBody).when().post(endPoint).then().extract()
				.response();
	}

}

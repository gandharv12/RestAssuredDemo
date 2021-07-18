package com.ui.rest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestRestassuredDemo {
	@Test
	
	void test_01()
/*	{
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
	}
*/
	{
		  RestAssured.baseURI="https://rahulshettyacademy.com";
		  given().log().all().queryParam("key",
		  "qaclick123").header("Content-Type","application/json").body("{\n" +
		  "  \"location\": {\n" + "    \"lat\": -376522.383494,\n" +
		  "    \"lng\": 337865867.427362\n" + "  },\n" + "  \"accuracy\": 50,\n" +
		  "  \"name\": \"Frontline house\",\n" +
		  "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
		  "  \"address\": \"29, side layout, cohen 09\",\n" + "  \"types\": [\n" +
		  "    \"xyzdr\",\n" + "    \"testing\"\n" + "  ],\n" +
		  "  \"website\": \"http://google.com\",\n" + "  \"language\": \"French-IN\"\n"
		  + "}").when().post("maps/api/place/add/json").then().log().all().statusCode(200).body("Scope",equalTo("APP") )
		  .header("server","Apache/2.4.18 (Ubuntu)");
	}
}

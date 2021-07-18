package com.ui.rest;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ReadStaticfileJson {
@Test
	
	void test_02() throws IOException

	{
		  RestAssured.baseURI="https://rahulshettyacademy.com";
	String response =	  given().queryParam("key",
		  "qaclick123").header("Content-Type","application/json")
		  .body(new String(Files.readAllBytes(Paths.get("/Users/gandharavmehra/Desktop/Development/addplace.json")))).when().post("maps/api/place/add/json")
		  .then().statusCode(200).extract().response().asString();
	
	System.out.println("************"+ response);
	
	JsonPath js = new JsonPath(response);
	
	String placeid=js.getString("place_id");
	
	System.out.println("************"+ placeid);

}
}

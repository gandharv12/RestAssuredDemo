package com.ui.rest;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestRestassuredDemo1 {
	@Test
	
	void test_01()
/*	{
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
	}
*/
	//Addplace->update place with new address->Getplace to validate if new place is added and present in response
	{
		  RestAssured.baseURI="https://rahulshettyacademy.com";
	String response =	  given().log().all().queryParam("key",
		  "qaclick123").header("Content-Type","application/json")
		  .body(Payload.Addplace()).when().post("maps/api/place/add/json")
		  .then().statusCode(200).extract().response().asString();
	
	System.out.println("************"+ response);
	
	JsonPath js = new JsonPath(response);
	
	String placeid=js.getString("place_id");
	
	System.out.println("************"+ placeid);
	
	//update Place
	
	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
			+ "\"place_id\":\""+placeid+"\",\r\n"
			+ "\"address\":\"70 Summer walk 93 90, USA\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}")
	.when().put("/maps/api/place/update/json")
	.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
	
	//get place
	
	String Getplaceresponse = given().log().all().queryParam("Key", "qaclick123").queryParam("placeid", placeid).
			when().get("maps/api/place/get/json")
			 .then().statusCode(200).extract().response().asString();
	
	System.out.println("+++++------- "+ Getplaceresponse);
	
//	JsonPath JS1 = new JsonPath(getplaceresponse);
//    String actualaddress = JS1.getString("address");
//	System.out.println("----------"+ actualaddress);
//	Assert.assertEquals(actualaddress, "70 Summer walk 93 90, USA");
	}
}

package com.ui.rest;

import org.testng.annotations.Test;

import pojo.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class SpecBuildertest {
	
	@Test
	
	public void Serializationtest()
	{
		
		Addplace1 p = new Addplace1();
		p.setAccuracy(50);
		p.setAddress("716A 8889 Changi1 City 1098");
		p.setLanguage("French-IN");
		p.setPhone_number("+76 99999981");
		p.setName("Front line");
		p.setWebsite("www.//sagdka9/");
		List<String> mylist = new ArrayList<String>();
		mylist.add("Xenophobeia11");
		mylist.add("implicit11");
		
		p.setTypes(mylist);
		
		
		Location loc = new Location();
		loc.setLat(-67.98877);
		loc.setLng(836984.3337);
		p.setLocation(loc);
		
RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();		
		
	
	RequestSpecification res =given().spec(req)
			.body(p);
	
	
	Response response= res.when().post("maps/api/place/add/json").then().spec(resspec).extract().response();
	
	String 	responseString = response.asString();
	
	System.out.println(responseString);
	
	JsonPath js = new JsonPath(responseString);
 //assertEquals(js.get("Scope"), expected);
	
	}

	
}

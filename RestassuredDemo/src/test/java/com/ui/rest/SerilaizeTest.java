package com.ui.rest;

import org.testng.annotations.Test;

import pojo.*;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SerilaizeTest {
	
	@Test
	
	public void Serializationtest()
	{
		
		Addplace1 p = new Addplace1();
		p.setAccuracy(50);
		p.setAddress("716A 8889 Changi City 1098");
		p.setLanguage("French-IN");
		p.setPhone_number("+76 9999998");
		p.setName("Front line");
		p.setWebsite("www.//sagdka/");
		List<String> mylist = new ArrayList<String>();
		mylist.add("Xenophobeia");
		mylist.add("implicit");
		
		p.setTypes(mylist);
		
		
		Location loc = new Location();
		loc.setLat(-67.98877);
		loc.setLng(836984.3337);
		p.setLocation(loc);
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	String Respp=	given().log().all().queryParam("Key", "qaclick123").body(p)
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();	
	
	System.out.println(Respp);
	
	}

	
}

package com.ui.rest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Dynamicjson {
	
	@Test(dataProvider="Bookdata")
	public void addBook(String bookname, String isbnn, String aisle1, String authorname)
	{
		RestAssured.baseURI= "http://216.10.245.166";
	String addbookresponse1=	given().header("Content-Type","application/json")
		.body(Payload.AddBook(bookname,isbnn,aisle1,authorname))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat()
		.statusCode(200)
		.extract().response().asString();
	
	JsonPath js = new JsonPath(addbookresponse1);
	String id= js.get("ID");
	System.out.println(id);
	
	//Delete the post
	
	given().log().all().header("Content-Type", "application/json")
	.body("{\n"
			+ " \"ID\" : \""+id+"\"\n"
			+ " } ").when().delete("Library/DeleteBook.php")
	.then().log().all().assertThat().statusCode(200);
	}
	
	@DataProvider(name="Bookdata")
	public Object[][] getdata()
	{
		return new Object[][] {{ "the Epic world13","bucky12","987650018","Jagjit Singh1"}, {"the Epic world133","bucky144","9876500144", "Daljit Singh "}}; 
	}
		
}
	
package jirautomate.co.mm;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import  static io.restassured.RestAssured.*;

import java.io.File;

public class AutheticateJIRA {
	
	@Test
	
	public void AutomateJIRA()
	{
		
		RestAssured.baseURI="http://localhost:8080";
		
		SessionFilter session = new SessionFilter();
		given().log().all().header("Content-Type","application/json").body("{ \"username\": \"Gandharv.mehra20\", \"password\": \"Jira1234\" }").filter(session)
		.when().post("rest/auth/1/session").then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	
		
		
	String commentresponse= 	given().log().all().header("Content-Type","application/json").body("{\n"
				+ "    \"body\": \"File has been attached.\"\n"
				+ "}").filter(session).when().post("rest/api/2/issue/TES-2/comment").then().assertThat().statusCode(201).extract().response().asString();
		
		given().header("X-Atlassian-Token","no-check").filter(session).header("Content-Type","multipart/form-data").multiPart("file",new File("/Users/gandharavmehra/eclipseprojects/RestassuredDemo/src/test/resources/test2.txt"))
		.when().post("rest/api/2/issue/TES-2/attachments").then().log().all().assertThat().statusCode(200);
		
		JsonPath js = new JsonPath(commentresponse);
		String Commentid =js.getString("id");
		System.out.println("Comment id is $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$: "+ Commentid);
		
		
		
	String issuedetails =	given().filter(session).log().all().queryParam("fields", "comment")
		.when().get("rest/api/2/issue/TES-2")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
	System.out.println("--------------"+"***************");
	System.out.println(issuedetails);
	
	//since issue details is in a array of comments we have to itrate through each comment deyails.
	JsonPath js1 = new JsonPath(issuedetails);
int commentsize=	js1.getInt("fields.comment.comments.size()");

for (int i=0;i<commentsize;i++)
{
	String commentid=js1.get("fields.comment.comments["+i+"].id").toString();
	System.out.println(commentid);
	if (commentid.equalsIgnoreCase(Commentid))
	{
		System.out.println("New Commentadded with id :"+ Commentid);
	}
	///you can use assert also here
}
	}

}

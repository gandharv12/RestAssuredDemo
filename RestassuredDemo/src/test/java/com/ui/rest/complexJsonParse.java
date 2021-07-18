package com.ui.rest;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;


@Test
public class complexJsonParse {
public void testjson()
	{
		// TODO Auto-generated method stub
		
		JsonPath js2 = new JsonPath(Payload.Courseprice());
	int ncount=	js2.getInt("courses.size()");
	System.out.println("count is"+ ncount);
	
	int totalamount =js2.getInt("dashboard.purchaseAmount");
	System.out.println(totalamount);
	//print title of the first course
	String coursetitle1 =js2.getString("courses[0].title");
	
	System.out.println(coursetitle1);
	int sum=0;
	for(int i=0;i<ncount;i++)
	{
	String tt=	js2.getString("courses["+i+"].title");
	int hh=	js2.get("courses["+i+"].price");
	int mm=	js2.get("courses["+i+"].copies");
		
		System.out.println("--"+ tt +" ---- "+ hh +"   ----- "+ mm);
		int totalamountcal= hh*mm;
		
		sum =sum+ totalamountcal;
		
		
	}
	
	System.out.println("sum is"+sum);
	Assert.assertEquals(sum, totalamount);
	

	System.out.println("print no of copies for RPA");
	
	for(int i=0;i<ncount;i++)
	{
		String tt=	js2.getString("courses["+i+"].title");
		if (tt.equalsIgnoreCase("RPA"))
		{
			int hh=	js2.get("courses["+i+"].price");
			int mm=	js2.get("courses["+i+"].copies");
			
			System.out.println( "total no of copies sent:"+ mm);
			break;
		}
		
		
	}
	
	}
	

}

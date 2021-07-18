package files;

public class Payload {
	
	public static String Addplace(){
		
		return "{\n"
				+ "  \"location\": {\n"
				+ "    \"lat\": -376511.383494,\n"
				+ "    \"lng\": 3378658889.427362\n"
				+ "  },\n"
				+ "  \"accuracy\": 50,\n"
				+ "  \"name\": \"Frontline house\",\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\n"
				+ "  \"address\": \"78, sid11 layout, cohen 09\",\n"
				+ "  \"types\": [\n"
				+ "    \"xyzdr549988765\",\n"
				+ "    \"testing8u987\"\n"
				+ "  ],\n"
				+ "  \"website\": \"http://google.com\",\n"
				+ "  \"language\": \"French-IN\"\n"
				+ "}";
	}

	public static String Courseprice()
	{
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 1162,\r\n" + 
				"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Selenium Python\",\r\n" + 
				"      \"price\": 50,\r\n" + 
				"      \"copies\": 6\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Cypress\",\r\n" + 
				"      \"price\": 40,\r\n" + 
				"      \"copies\": 4\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"RPA\",\r\n" + 
				"      \"price\": 45,\r\n" + 
				"      \"copies\": 10\r\n" + 
				"    },\r\n" + 
				"     {\r\n" + 
				"      \"title\": \"Appium\",\r\n" + 
				"      \"price\": 36,\r\n" + 
				"      \"copies\": 7\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"  ]\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static  String AddBook(String name, String isbnn, String Aisle, String Author)
	{
		String payload ="{\n"
				+ "\n"
				+ "\"name\":\""+name+"\",\n"
				+ "\"isbn\":\""+isbnn+"\",\n"
				+ "\"aisle\":\""+Aisle+"\",\n"
				+ "\"author\":\""+Author+"\"\n"
				+ "}";
		return payload;
		
	}
}

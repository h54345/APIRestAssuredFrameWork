 package getRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetData {
	
	//@Test(priority=0)
	public void testResponseCode()
	{
		
	Response resp=RestAssured.post("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	
	String data= resp.asString();
	System.out.println("Data of 0 : "+data);
	
	int code= resp.getStatusCode();
	
	System.out.println("Status Code: " +code);
	
	Assert.assertEquals(code, 200);
		
	}
	
	@Test(priority = 3)
	public void posttest() {
		
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type","application/json");

		JSONObject json = new JSONObject();
		json.put("id","27");
		json.put("title","ThirdPost");
		json.put("author","LearningassuredPost");

		request.body(json.toJSONString());

		Response resp = request.post("http://localhost:3000/posts");
		String data= resp.asString();
		int code = resp.getStatusCode();
		System.out.println("Status Code: " + code);
		System.out.println("Data"+data);
		Assert.assertEquals(code, 201);

	}

	//@Test(priority=1)
	public void testBody()
	{
		Response resp=RestAssured.get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/");
		
		String data= resp.asString();
		int code= resp.getStatusCode();
		System.out.println("Status Code: "+code);
		System.out.println("Data"+data);
		System.out.println(resp.contentType());
		System.out.println("Response Time :"+resp.getTime());
		
	}
	
	}



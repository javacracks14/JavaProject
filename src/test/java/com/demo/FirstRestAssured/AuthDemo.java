package com.demo.FirstRestAssured;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthDemo 
{
	private String token;
	@Test
	public void createUser()
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com/swagger";
		RequestSpecification req = RestAssured.given();
		JSONObject obj = new JSONObject();
		obj.put("userName","Kunal");
		obj.put("password","kunal@123");
		req.header("Content-Type","application/json");
    	req.body(obj.toJSONString());
		Response res = req.post("/Account/v1/User");
		int status = res.getStatusCode();
		System.out.println(status);
	}
	@Test
	public void authBookstore()
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com/swagger";
		RequestSpecification req = RestAssured.given();
		JSONObject obj = new JSONObject();
		obj.put("userName","Kunal");
		obj.put("password","kunal@123");
		req.header("Content-Type","application/json");
    	req.body(obj.toJSONString());
		Response res = req.post("/Account/v1/GenerateToken");
		int status = res.getStatusCode();
		System.out.println(status);
		token = res.getBody().asPrettyString();
		System.out.println(token);
	}
	@Test
	public void applyingAuth()
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com/swagger";
		RequestSpecification req = RestAssured.given().auth().oauth2(token);
	}
}

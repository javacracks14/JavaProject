package com.demo.FirstRestAssured;

import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class AppTest 
{
    
    @Test
    public void testPutMethod()
    {
    	RestAssured.baseURI = "https://reqres.in";  // set the URL
    	RequestSpecification req = RestAssured.given();  // Request
    	
    	String data="{\r\n"
    			+ "    \"name\": \"morpheus\",\r\n"
    			+ "    \"job\": \"leader\"\r\n"
    			+ "}";
    			
    	
    	req.header("Content-Type","application/json");
    	req.body(data);
    	
    	Response res = req.put("/api/users/2");
    	ResponseBody resbody = res.getBody();
    	System.out.println(resbody.asString()); 
    }
//    @Test
//    public void testPatchMethod()
//    {
//    	RestAssured.baseURI = "https://reqres.in";  // set the URL
//    	RequestSpecification req = RestAssured.given();  // Request
//    	
//    	JSONObject obj = new JSONObject();
//    	obj.put("name", "Neelima");
//    	obj.put("job", "Leader");
//    	
//    	req.header("Content-Type","application/json");
//    	req.body(obj.toJSONString());
//    	
//    	Response res = req.patch("/api/users/2");
//    	ResponseBody resbody = res.getBody();
//    	System.out.println(resbody.asString()); 
//    }
//    @Test
//    public void testDeleteMethod()
//    {
//    	RestAssured.baseURI = "https://reqres.in";  // set the URL
//    	RequestSpecification req = RestAssured.given();  // Request
//    	Response res = req.delete("/api/users/2");
//    	System.out.println(res.getStatusCode());
//    }
}
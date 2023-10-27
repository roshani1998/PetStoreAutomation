package api.endpoints;

import com.github.scribejava.core.model.Response;

import api.Payload.User;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

//UserEndpoints.java
//Created to perform create, read, update and delete request to user API

public class UserEndpoints2 
{

	 static ResourceBundle getUrl() 
	{
		 //Method for getting Url's from properties file 
		 ResourceBundle routes= ResourceBundle.getBundle("routes");   //Load property file
		 return routes;
	}
	
	
	public static io.restassured.response.Response CreateUser(User Payload)
	{
		String post_url= getUrl().getString("post_url");
		
		io.restassured.response.Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.body(Payload)
		.post(post_url);
		return response;
	}
	
	public static io.restassured.response.Response ReadUser(String userName)
	{
		String get_url = getUrl().getString("get_url");
		
		io.restassured.response.Response response = given()
		      .pathParam("username", userName)
		.when()
		
		.get(get_url);
		return response;
	}
	
	public static io.restassured.response.Response updateUser(String userName, User payload)
	{
		String update_url = getUrl().getString("update_url");
		
		io.restassured.response.Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.when()
		.body(payload)
		.put(update_url);
		return response;
	}
	
	public static io.restassured.response.Response DeleteUser(String userName)
	{
		String delete_url = getUrl().getString("delete_url");
		
		io.restassured.response.Response response = given()
		.pathParam("username", userName)
		.when()
		
		.delete(delete_url);
		return response;
	}

}

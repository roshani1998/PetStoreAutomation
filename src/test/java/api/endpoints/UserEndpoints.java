package api.endpoints;

import com.github.scribejava.core.model.Response;

import api.Payload.User;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

//UserEndpoints.java
//Created to perform create, read, update and delete request to user API

public class UserEndpoints 
{

	public static io.restassured.response.Response CreateUser(User Payload)
	{
		io.restassured.response.Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.body(Payload)
		.post(Routes.post_url);
		return response;
	}
	
	public static io.restassured.response.Response ReadUser(String userName)
	{
		io.restassured.response.Response response = given()
		      .pathParam("username", userName)
		.when()
		
		.get(Routes.get_url);
		return response;
	}
	
	public static io.restassured.response.Response updateUser(String userName, User payload)
	{
		io.restassured.response.Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.when()
		.body(payload)
		.put(Routes.update_url);
		return response;
	}
	
	public static io.restassured.response.Response DeleteUser(String userName)
	{
		io.restassured.response.Response response = given()
		.pathParam("username", userName)
		.when()
		
		.delete(Routes.delete_url);
		return response;
	}

}

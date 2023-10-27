package api.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Payload.User;
import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import io.restassured.response.Response;

public class UserTests2 
{

	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void SetupData() 
	{
		faker= new Faker();
		userPayload= new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//log
		logger= LogManager.getLogger(this.getClass());
		
		logger.debug("debugging......");
		
	}
	
	@Test(priority = 1)
	public void TestPostUser() 
	{
		
		logger.info("************* Creating User ********************");
		Response response= UserEndpoints2.CreateUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* User is created ********************");
	}
	
	@Test(priority = 2)
	public void TestGetUserByName() 
	{
		logger.info("************** Reading User ***************");
		Response response= UserEndpoints2.ReadUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************** User info is displayed  ***************");
		
	}
	
	@Test(priority= 3)
	public void TestUpdateUserByName() 
	{
		logger.info("************* Updating User ****************");
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());  
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response= UserEndpoints2.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		//response.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************* User updated ****************");
		
		//checking data after update 
		Response responseAfterupdate= UserEndpoints2.ReadUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 4)
	public void TestDeleteUserByName() 
	{
		logger.info("*********** Deleting User **************");
		Response response= UserEndpoints2.DeleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*********** User deleted  **************");
	}
}

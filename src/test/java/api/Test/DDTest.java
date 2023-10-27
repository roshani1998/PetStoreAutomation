package api.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.Payload.User;
import api.Utilities.DataProviders;
import api.endpoints.UserEndpoints;
import io.restassured.response.Response;

public class DDTest 
{

	@Test(priority = 1, dataProvider = "Data", dataProviderClass= DataProviders.class)
	public void TestPostUser(String UserId, String userName, String fName, String lName, String userEmail, String Pwd, String Ph) 
	{
		
		User userPayload= new User();
		userPayload.setId(Integer.parseInt(UserId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(Pwd);
		userPayload.setPhone(Ph);
		
		Response response= UserEndpoints.CreateUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void TestDeleteUser(String userName) 
	{
		Response response= UserEndpoints.DeleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}

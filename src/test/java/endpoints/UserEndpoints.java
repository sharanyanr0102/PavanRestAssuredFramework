package endpoints;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

// Contains CRUD method implementation

public class UserEndpoints {
	
	public static Response createUser(User payload)
	{
		Response response = 
				given().header("Authorization", "Bearer 341fd9703d30d2bbd9d6fe82cf77f84c5baf8e2a5f36f0c72f6bc58fffa34833").
				contentType(ContentType.JSON).body(payload).
				when().post(Routes.createUser);
		return response;
	}
	
	public static Response getUser(int id)
	{
		Response response = 
				given().header("Authorization", "Bearer 341fd9703d30d2bbd9d6fe82cf77f84c5baf8e2a5f36f0c72f6bc58fffa34833").
				pathParam("id", id).
				when().get(Routes.getUser);
		return response;
	}
	
	public static Response updateUser(User payload, int id)
	{
		Response response = 
				given().header("Authorization", "Bearer 341fd9703d30d2bbd9d6fe82cf77f84c5baf8e2a5f36f0c72f6bc58fffa34833").
				contentType(ContentType.JSON).body(payload).pathParam("id", id).
				when().put(Routes.updateUser);
		return response;
	}
	
	public static Response deleteUser(int id)
	{
		Response response = 
				given().header("Authorization", "Bearer 341fd9703d30d2bbd9d6fe82cf77f84c5baf8e2a5f36f0c72f6bc58fffa34833").
				pathParam("id", id).
				when().delete(Routes.deleteUser);
		return response;
	}
}

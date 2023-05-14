package endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

// Contains CRUD method implementation

public class UserEndpoints1 {
	
	public static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload)
	{
		String post_url = getURL().getString("post_url");
		Response response = 
				given().header("Authorization", "Bearer 341fd9703d30d2bbd9d6fe82cf77f84c5baf8e2a5f36f0c72f6bc58fffa34833").
				contentType(ContentType.JSON).body(payload).
				when().post(post_url);
		return response;
	}
	
	public static Response getUser(int id)
	{
		String put_url = getURL().getString("put_url");
		Response response = 
				given().header("Authorization", "Bearer 341fd9703d30d2bbd9d6fe82cf77f84c5baf8e2a5f36f0c72f6bc58fffa34833").
				pathParam("id", id).
				when().get(put_url);
		return response;
	}
	
	public static Response updateUser(User payload, int id)
	{
		String put_url = getURL().getString("put_url");
		Response response = 
				given().header("Authorization", "Bearer 341fd9703d30d2bbd9d6fe82cf77f84c5baf8e2a5f36f0c72f6bc58fffa34833").
				contentType(ContentType.JSON).body(payload).pathParam("id", id).
				when().put(put_url);
		return response;
	}
	
	public static Response deleteUser(int id)
	{
		String put_url = getURL().getString("put_url");
		Response response = 
				given().header("Authorization", "Bearer 341fd9703d30d2bbd9d6fe82cf77f84c5baf8e2a5f36f0c72f6bc58fffa34833").
				pathParam("id", id).
				when().delete(put_url);
		return response;
	}
}

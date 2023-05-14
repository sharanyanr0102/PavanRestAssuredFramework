package endpoints;

// Contains URL

public class Routes {
	public static String baseURL = "https://gorest.co.in/public/v2";
	public static String createUser = baseURL+"/users";
	public static String updateUser = baseURL+"/users/{id}";
	public static String getUser = baseURL+"/users/{id}";
	public static String deleteUser = baseURL+"/users/{id}";
}

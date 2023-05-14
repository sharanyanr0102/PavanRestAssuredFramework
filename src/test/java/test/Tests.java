package test;

import org.testng.annotations.Test;

import payload.User;

import com.github.javafaker.Faker;

import endpoints.UserEndpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class Tests {
	Faker faker;
	User user;
	
	@Test
	public void setPayLoad()
	{
		faker = new Faker();
		user = new User();
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String name = fname+" "+lname;
		user.setName(name);
		
		String email = fname+"."+lname+"@gmail.com";
		user.setEmail(email);
		
		String gender = "male";
		user.setGender(gender);
		
		String status = "inactive";
		user.setStatus(status);
		/*
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getGender());
		System.out.println(user.getStatus());
		*/
	}
	
	@Test(priority = 1,dependsOnMethods = {"setPayLoad"})
	public void testCreateUser()
	{
		Response createUser = UserEndpoints.createUser(user);
		createUser.
		then().assertThat().statusCode(201).and().body("name", equalTo(user.getName())).and().body("email", equalTo(user.getEmail())).and().body("gender", equalTo(user.getGender())).and().body("status", equalTo(user.getStatus())).
		log().body();
		JsonPath jsonPath = new JsonPath(createUser.asString());
		user.setId(jsonPath.getInt("id"));
	}
	
	@Test(priority = 2)
	public void testGetUser()
	{
		Response createUser = UserEndpoints.getUser(user.getId());
		createUser.
		then().assertThat().statusCode(200).
		log().body();
	}
	
	@Test(priority = 3)
	public void testUpdateUser()
	{
		faker = new Faker();
		String[] words = user.getName().split(" ");
		String email = words[1]+"."+words[0]+"@gmail.com";
		user.setEmail(email);
		
		String status = "active";
		user.setStatus(status);
		
		Response createUser = UserEndpoints.updateUser(user, user.getId());
		createUser.
		then().assertThat().statusCode(200).and().body("id", equalTo(user.getId())).and().body("name", equalTo(user.getName())).and().body("email", equalTo(user.getEmail())).and().body("gender", equalTo(user.getGender())).and().body("status", equalTo(user.getStatus())).
		log().body();
	}
	
	@Test(priority = 4)
	public void testDeleteUser()
	{
		Response createUser = UserEndpoints.deleteUser(user.getId());
		createUser.
		then().assertThat().statusCode(204).
		log().body();
	}
}

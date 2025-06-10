package Day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.module.jsv.JsonSchemaValidator.*;


public class HTTPRequest {
	

	int id;
	
	@Test (priority=1)
	public void getUsers() {
		
		given()
		 .header("x-api-key", "reqres-free-v1")
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	 		
	}
	
	@Test (priority=2)
	public void createUsers() {
		
		HashMap data= new HashMap();
		
		data.put("name", "Anuradha");
		data.put("job", "Engineer");
		
		
		Response response=given()
	    .contentType("application/json")
	    .header("x-api-key", "reqres-free-v1")
	    .body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.log().all()
		.extract().response()	;
	
		
		
	id=response.jsonPath().getInt("id")	;
	System.out.println("New created user id is : "+id);
		
		
	}

	
	@Test (priority=3,dependsOnMethods= {"createUsers"})
	public void updateUser() {
		
HashMap data= new HashMap();
		
		data.put("name", "Abhishek");
		data.put("job", "Manager");
		
		
		Response response=given()
		
		 .contentType("application/json")
		 .body(data)
		 .header("x-api-key", "reqres-free-v1")
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(200)
		.log().all()
		.extract().response();
		
		
		
		System.out.println("Updated UserName is: "+response.jsonPath().getString("name"));
		System.out.println("Updated job is : "+response.jsonPath().getString("job"));
			
		
	}
	
	@Test(priority=4)
	public void deleteUser() {
		
		given()
		 .header("x-api-key", "reqres-free-v1")
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
	}
}

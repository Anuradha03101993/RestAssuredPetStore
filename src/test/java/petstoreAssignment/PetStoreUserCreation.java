package petstoreAssignment;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PetStoreUserCreation {
	
	
	private static final String BASE_URI = "https://petstore.swagger.io/v2";
	
	
	
public void createUsers(String username ) {
		
		HashMap data= new HashMap();
		
		    Map<String, Object> user = new HashMap<>();
	        user.put("id", 11111);
	        user.put("username", username);
	        user.put("firstName", "Anu");
	        user.put("lastName", "Bharti");
	        user.put("email", "anutest@gmail.com");
	        user.put("password", "123456");
	        user.put("phone", "9876543210");
	        user.put("userStatus", 1011);
		
		
		Response response=given()
	    .contentType("application/json")
	  	.body(data)
		
		.when()
		.post(BASE_URI+"/user")
		
		.then()
		.statusCode(200)
		.log().all()
		.extract().response()	;
	
			
			
	}
	
    public String getUser(String username) {
    	
    	return RestAssured
    	 .given()
         .when().get("https://petstore.swagger.io/v2/user/"+username)
         .then().statusCode(200).log().all()
         .extract().body().asString();
    	
    }


}

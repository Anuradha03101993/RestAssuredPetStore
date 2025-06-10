package petstoreAssignment;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import java.util.*;

public class GetSoldPets {
	 private static final String BASE_URI = "https://petstore.swagger.io/v2";

	    public GetSoldPets() {
	        RestAssured.baseURI = BASE_URI;
	    }

	    public List<Map<String, Object>> getSoldPets() {
	        Response response = RestAssured
	                .given().queryParam("status", "sold")
	                .when().get("/pet/findByStatus")
	                .then().statusCode(200)
	                .extract().response();

	        JsonPath json = response.jsonPath();
	        List<Map<String, Object>> pets = json.getList("$");

	        List<Map<String, Object>> result = new ArrayList<>();
	        for (Map<String, Object> pet : pets) {
	            Map<String, Object> item = new HashMap<>();
	            item.put("id", pet.get("id"));
	            item.put("name", pet.get("name"));
	            result.add(item);
	        }

	        return result;
	    }
	}



package petstoreAssignment;

import java.util.List;
import java.util.Map;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class FinalAssignment {

	public static void main(String[] args) {
		
		// Random userDetails values for creating user
		Faker faker = new Faker();
		String randUserName = "AnuPetStore" + faker.number().digits(2);
		System.out.println(randUserName);
		int randomID = faker.number().numberBetween(1000, 9999);
		int randomUserStatus = faker.number().numberBetween(100, 999);
		
		 // Step 1: Create and fetch user
		String username= randUserName;
        PetStoreUserCreation userDetails = new PetStoreUserCreation();
        System.out.println("Creating user...");
        System.out.println("Username while creating the user is : "+username);
        System.out.println("UserID while retriving the user is : "+randomID);
        System.out.println("UserStatus while retriving the user is : "+randomUserStatus);
        userDetails.createUsers(username,randomID,randomUserStatus);
        
        System.out.println("Retrieving user...");
        System.out.println("Username while retriving the user is : "+username);
     
        
        String responseBody=userDetails.getUser(username);
        System.out.println("responseBody : "+responseBody);

        // Step 2: Get sold pets
        GetSoldPets petService = new GetSoldPets();
        List<Map<String, Object>> soldPets = petService.getSoldPets();
        System.out.println("Sold Pets {id, name}:");
        for (Map<String, Object> pet : soldPets) {
            System.out.println(pet);
        }

        // Step 3: Analyze pet names and count
        GetRepeatedPetName analyzer = new GetRepeatedPetName(soldPets);
        Map<String, Integer> nameCounts = analyzer.countPetNames();
        System.out.println("Pet Name Counts:");
        System.out.println(nameCounts);
    

	}

}

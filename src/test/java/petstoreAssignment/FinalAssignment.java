package petstoreAssignment;

import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

public class FinalAssignment {

	public static void main(String[] args) {
		
		 // Step 1: Create and fetch user
        PetStoreUserCreation userDetails = new PetStoreUserCreation();
        String username = "AnuradhaPetStore0";
        System.out.println("Creating user...");
        userDetails.createUsers(username);
        System.out.println("Retrieving user...");
        String responseBody=userDetails.getUser("AnuradhaPetStore");
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

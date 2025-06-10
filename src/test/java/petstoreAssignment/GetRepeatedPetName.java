package petstoreAssignment;
import java.util.*;

public class GetRepeatedPetName {
	

    private List<Map<String, Object>> petList;

    public GetRepeatedPetName(List<Map<String, Object>> petList) {
        this.petList = petList;
    }

    public Map<String, Integer> countPetNames() {
        Map<String, Integer> nameCounts = new HashMap<>();
        for (Map<String, Object> pet : petList) {
            String name = (String) pet.get("name");
            if (name != null && !name.isEmpty()) {
                nameCounts.put(name, nameCounts.getOrDefault(name, 0) + 1);
            }
        }
        return nameCounts;
    }
}


